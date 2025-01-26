public class UserAgent {

    private final String operatingSystem;
    private final String browser;

    public UserAgent(String userAgent) {
        this.browser = defineBrowser(userAgent);
        this.operatingSystem = defineOperatingSystem(userAgent);

    }

    // Находим браузер в строке
    private String defineBrowser(String userAgent){
        String definedBrowser = null;
        int endIndex = userAgent.indexOf(" ");
        if (endIndex != -1) {
            definedBrowser = userAgent.substring(1, endIndex);
        }
        return definedBrowser;
    }
    // Находим ОС в строке
    private String defineOperatingSystem(String userAgent){
        String definedOperatingSystem = null;
        int startIndex = userAgent.indexOf("(");
        int endIndex = userAgent.indexOf(";");
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            definedOperatingSystem = userAgent.substring(startIndex + 1, endIndex);
        }
        return definedOperatingSystem;
    }


    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getBrowser() {
        return browser;
    }
}
