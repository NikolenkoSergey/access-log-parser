import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogEntry {
    private final String ipAddress;
    private final LocalDateTime dataTime;
    private final RequestMethods method;
    private final String requestPath;
    private final int responseCode;
    private final int dataSize;
    private final String referer;
    private final String userAgent;


    public LogEntry(String line) {
        String[] arrayOfLines = line.split(" ");
        String method = arrayOfLines[5].substring(1);


        String userAgent = "";
        for (int i = 11; i < arrayOfLines.length; i++) {
            userAgent += " " + arrayOfLines[i];
        }
        userAgent = userAgent.substring(1);

        this.ipAddress = arrayOfLines[0];
        this.dataTime = parsDateTime(line);
        this.method = RequestMethods.valueOf(method);
        this.requestPath = arrayOfLines[6];
        this.responseCode = Integer.parseInt(arrayOfLines[8]);
        this.dataSize = Integer.parseInt(arrayOfLines[9]);
        this.referer = arrayOfLines[10];
        this.userAgent = userAgent;
    }

    // Парсим дату
    private LocalDateTime parsDateTime(String line){
        // Убираем [] у даты
        String[] arrayOfLines = line.split(" ");
        String dateTime = arrayOfLines[3] +" "+ arrayOfLines[4];
        dateTime = dateTime.substring(1, dateTime.length()-1);

        // Создаем форматтер для парсинга строки
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z").withLocale(Locale.US);

        // Парсим строку в объект LocalDateTime
        return LocalDateTime.parse(dateTime, formatter);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public RequestMethods getMethod() {
        return method;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getDataSize() {
        return dataSize;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
