import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Statistics {
    private static Long totalTraffic;
    private static LocalDateTime minTime;
    private static LocalDateTime maxTime;
    private static HashSet<String> pages;
    private static HashSet<String> nonExistingPages;
    private static HashMap<String, Integer> operatingSystem;
    private static HashMap<String, Integer> browser;
    private static int botCount;
    private static int errorResponseCount;
    private static int totalVisits;
    private static HashSet<String> users;
    private static HashSet<String> referringDomains;
    private static HashMap<LocalDateTime, Integer> visitsPerSecond;
    private static HashMap<String, Integer> userVisitsCounter;
    private static  Integer maxUserVisits;

    public Statistics() {
        totalTraffic = 0L;
        minTime = LocalDateTime.now();
        maxTime = LocalDateTime.now();
        pages = new HashSet<>();
        nonExistingPages = new HashSet<>();
        operatingSystem = new HashMap<>();
        browser = new HashMap<>();
        botCount = 0;
        errorResponseCount = 0;
        users = new HashSet<>();
        visitsPerSecond = new HashMap<>();
        referringDomains = new HashSet<>();
        userVisitsCounter = new HashMap<>();
        maxUserVisits =0;
    }


    public static void addEntry(LogEntry logEntry) {
        UserAgent userAgent = new UserAgent(logEntry.getUserAgent());
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

        referringDomains(logEntry);
        peakTraffic(logEntry, userAgent);
        errorResponseCount(logEntry);
        minMaxTime(logEntry);

        //Все визиты + Уникальные пользователи
        if (!userAgent.isBot()) {
            totalVisits++;
            users.add(logEntry.getIpAddress());
        }

        //количество ботов
        if (userAgent.isBot()) botCount++;

        browserCounter(userAgent);
        operatingSystemCounter(userAgent);
        MaxUserVisitsCalculator(logEntry, userAgent);


    }

    //========================================================

    //Максимальная посещаемость одним пользователем
    private static void MaxUserVisitsCalculator(LogEntry logEntry, UserAgent userAgent) {
        if (!userAgent.isBot()) {
            if (userVisitsCounter.containsKey(logEntry.getIpAddress())) {
                userVisitsCounter.merge(logEntry.getIpAddress(), 1, Integer::sum);
            } else userVisitsCounter.put(logEntry.getIpAddress(), 1);
        }
        // Получаем коллекцию значений
        Collection<Integer> values = userVisitsCounter.values();

        // Находим максимальное значение
        maxUserVisits = Collections.max(values);
    }

    public static int getMaxUserVisits() {
        return maxUserVisits;
    }

    //HashMap ОС + количество
    private static void operatingSystemCounter(UserAgent userAgent) {
        if (operatingSystem.containsKey(userAgent.getOperatingSystem())) {
            operatingSystem.merge(userAgent.getOperatingSystem(), 1, Integer::sum);
        } else {
            operatingSystem.put(userAgent.getOperatingSystem(), 1);
        }
    }

    //Доля ОС
    public static HashMap<String, Double> calculateOsShares() {
        return calculateShares(operatingSystem);
    }

    private static HashMap<String, Double> calculateShares(HashMap<String, Integer> map) {
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


    //HashMap баузер + количество
    private static void browserCounter(UserAgent userAgent) {
        if (browser.containsKey(userAgent.getBrowser())) {
            browser.merge(userAgent.getBrowser(), 1, Integer::sum);
        } else {
            browser.put(userAgent.getBrowser(), 1);
        }
    }

    //Доля браузеров
    public static HashMap<String, Double> calculateBrowserShares() {
        return calculateShares(browser);
    }

    //Среднее количество посещений в час
    public static double getAverageVisits() {
        if (hoursBetween() == 0) {
            return 0.0;
        }

        int countBrowser = 0;
        HashMap<String, Double> shares = new HashMap<>();
        //Общее количество браузеров
        for (Integer value : browser.values()) {
            countBrowser += value;
        }
        return (double) (countBrowser - botCount) / hoursBetween();
    }

    public static HashMap<String, Integer> getBrowser() {
        return browser;
    }

    //min max Time
    private static void minMaxTime(LogEntry logEntry) {
        LocalDateTime time = logEntry.getDataTime();
        if (minTime.isAfter(time)) {
            minTime = time;
        }
        if (maxTime.isBefore(time)) {
            maxTime = time;
        }
    }

    //Все время в часах
    private static double hoursBetween() {
        Duration duration = Duration.between(minTime, maxTime);
        long hoursBetween = duration.toHours();

        if (hoursBetween == 0) {
            return 0.0;
        }
        return hoursBetween;
    }

    public static int getBotCount() {
        return botCount;
    }

    // Средняя посещаемость одним пользователем
    public static double getAverageVisitsPerUser() {
        return (double) totalVisits / users.size();
    }

    public LocalDateTime getMinTime() {
        return minTime;
    }

    public LocalDateTime getMaxTime() {
        return maxTime;
    }

    //количество ошибочных запросов
    private static void errorResponseCount(LogEntry logEntry) {
        if (logEntry.getResponseCode() >= 400 && logEntry.getResponseCode() <= 599)
            errorResponseCount++;
    }

    public static int getErrorResponseCount() {
        return errorResponseCount;
    }

    //Количество запросов в каждую секунду
    private static void peakTraffic(LogEntry logEntry, UserAgent userAgent) {
        if (!userAgent.isBot()) {
            if (visitsPerSecond.containsKey(logEntry.getDataTime())) {
                visitsPerSecond.merge(logEntry.getDataTime(), 1, Integer::sum);
            } else {
                visitsPerSecond.put(logEntry.getDataTime(), 1);
            }
        }
    }

    //Максимальное количество запросов в конкретную секунду
    public static int getPeakTraffic() {
        int peakTraffic = 0;
        for (Integer value : visitsPerSecond.values()) {
            if (value > peakTraffic) peakTraffic = value;
        }
        return peakTraffic;
    }

    //список доменных имен
    private static void referringDomains(LogEntry logEntry) {
        String domains;
        int start, end;
        start = logEntry.getReferer().indexOf("/") + 2;
        end = logEntry.getReferer().indexOf("/", start + 5);
        if (logEntry.getReferer().contains("//")) {
            domains = logEntry.getReferer().substring(start, end);
            if (domains.contains("www")) {
                domains = domains.substring(4);
                referringDomains.add(domains);
            } else referringDomains.add(domains);

        }

    }

    public static HashSet<String> getReferringDomains() {
        return referringDomains;
    }

    //Среднее количество трафика в час
    public static double getTrafficRate() {
        if (hoursBetween() == 0) {
            return 0.0;
        }
        return (double) totalTraffic / hoursBetween();
    }

    //Среднее количество ошибочных запросов в час
    public static double getAverageErrorResponse() {
        if (hoursBetween() == 0) {
            return 0.0;
        }
        return (double) errorResponseCount / hoursBetween();
    }

    public Long getTotalTraffic() {
        return totalTraffic;
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


    public static HashSet<String> getUsers() {
        return users;
    }

    public static HashMap<LocalDateTime, Integer> getVisitsPerSecond() {
        return visitsPerSecond;
    }
}
