import java.time.Duration;
import java.time.LocalDateTime;

public class Statistics {
    private static Long totalTraffic;
    private static LocalDateTime minTime;
    private static LocalDateTime maxTime;

    public Statistics() {
        totalTraffic = 0L;
        minTime = LocalDateTime.now();
        maxTime = LocalDateTime.now();
    }

    //Общее количество трафика и время
    public static void addEntry(LogEntry logEntry) {
        totalTraffic += logEntry.getDataSize();
        LocalDateTime time = logEntry.getDataTime();

        if (minTime.isAfter(time)) {
            minTime = time;
        }

        if (maxTime.isBefore(time)) {
            maxTime = time;
        }
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
}
