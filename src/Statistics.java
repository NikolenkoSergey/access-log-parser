import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Statistics {
    private static Long totalTraffic;
    private static LocalDateTime minTime;
    private static LocalDateTime maxTime;
    private static HashSet<String> pages;
    private static HashSet<String> nonExistingPages;
    private static HashMap<String, Integer> operatingSystem;
    private static HashMap<String, Integer> browser;

    public Statistics() {
        totalTraffic = 0L;
        minTime = LocalDateTime.now();
        maxTime = LocalDateTime.now();
        pages = new HashSet<>();
        nonExistingPages = new HashSet<>();
        operatingSystem = new HashMap<>();
        browser = new HashMap<>();
    }


    public static void addEntry(LogEntry logEntry) {
        //Весь трафик
        totalTraffic += logEntry.getDataSize();

        //Все страницы
        if (logEntry.getResponseCode() == 200) {
            if (logEntry.getRequestPath().indexOf("?") != -1)
                pages.add(logEntry.getRequestPath().substring(0, logEntry.getRequestPath().indexOf("?")));

        }

        //Не существующие страницы
        if (logEntry.getResponseCode() == 404) {
            if (logEntry.getRequestPath().indexOf("?") != -1)
                nonExistingPages.add(logEntry.getRequestPath().substring(0, logEntry.getRequestPath().indexOf("?")));

        }

        //HashMap c ОС + количество
        UserAgent ua = new UserAgent(logEntry.getUserAgent());
        if (operatingSystem.containsKey(ua.getOperatingSystem())) {
            operatingSystem.merge(ua.getOperatingSystem(), 1, Integer::sum);
        } else {
            operatingSystem.put(ua.getOperatingSystem(), 1);
        }

        //HashMap c баузер + количество
        if (browser.containsKey(ua.getBrowser())) {
            browser.merge(ua.getBrowser(), 1, Integer::sum);
        } else {
            browser.put(ua.getBrowser(), 1);
        }

        //min max Time
        LocalDateTime time = logEntry.getDataTime();
        if (minTime.isAfter(time)) {
            minTime = time;
        }

        if (maxTime.isBefore(time)) {
            maxTime = time;
        }
    }

    //Доля браузеров
    public static HashMap<String, Double> calculateBrowserShares() {
        return calculateShares(browser);
    }

    //Доля ОС
    public static HashMap<String, Double> calculateOsShares() {
        return calculateShares(operatingSystem);
    }

    private static HashMap<String, Double> calculateShares(HashMap<String, Integer> map){
        int count = 0;
        HashMap<String, Double> shares = new HashMap<>();
        //Общее количество
        for (Integer value : map.values()) {
            count += value;
        }
        //Доля
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double share = (double) entry.getValue() / count;
            shares.put(entry.getKey(), share);
        }
        return shares;
    }

    //Среднее количество трафика в час
    public static double getTrafficRate() {
        Duration duration = Duration.between(minTime, maxTime);
        long hoursBetween = duration.toHours();

        if (hoursBetween == 0) {
            return 0.0;
        }

        return (double) totalTraffic / hoursBetween;
    }

    public Long getTotalTraffic() {
        return totalTraffic;
    }

    public LocalDateTime getMinTime() {
        return minTime;
    }

    public LocalDateTime getMaxTime() {
        return maxTime;
    }

    public static HashSet<String> getPages() {
        return pages;
    }

    public static HashSet<String> getNonExistingPages() {
        return nonExistingPages;
    }

    public static HashMap<String, Integer> getOperatingSystem() {
        return operatingSystem;
    }

    public static HashMap<String, Integer> getBrowser() {
        return browser;
    }
}
