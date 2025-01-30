public class UserAgent {

    private final String operatingSystem;
    private final String browser;
    private final boolean bot;

    public UserAgent(String userAgent) {
        this.browser = defineBrowser(userAgent);
        this.operatingSystem = defineOperatingSystem(userAgent);
        this.bot = isBot(userAgent);

    }

    // Находим браузер в строке
    private String defineBrowser(String userAgent) {
        String browser = null;
        if (userAgent.contains("Edge")) {
            browser = "Edge";
        } else if (userAgent.contains("Firefox")) {
            browser = "Firefox";
        } else if (userAgent.contains("Chrome")) {
            browser = "Chrome";
        } else if (userAgent.contains("Opera")) {
            browser = "Opera";
        } else {
            browser = "Other";
        }
        return browser;
    }

    // Находим ОС в строке
    private String defineOperatingSystem(String userAgent) {
        String definedOperatingSystem = null;
        if (userAgent.contains("Windows")) {
            definedOperatingSystem = "Windows";
        } else if (userAgent.contains("Mac OS X") || userAgent.contains("macintosh")) {
            definedOperatingSystem = "Mac OS X";
        } else if (userAgent.contains("Linux")) {
            definedOperatingSystem = "Linux";
        } else {
            definedOperatingSystem = "Other";
        }
        return definedOperatingSystem;
    }

    private static boolean isBot(String userAgent) {
        return userAgent.contains("bot");
    }


    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getBrowser() {
        return browser;
    }

    public boolean isBot() {
        return bot;
    }
}
