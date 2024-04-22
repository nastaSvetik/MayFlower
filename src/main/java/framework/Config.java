package framework;


import static framework.PropertyLoader.retrieveProperty;


public class Config {
    public static String baseUrl = getBaseUrl();
    public static String apiURL = getApiUrl();
    public static String cookieDomain = getCookieDomain();
    public static String baseUserLogin = retrieveProperty("baseUserLogin");
    public static String baseUserPassword = retrieveProperty("baseUserPassword");
    public static String sessionCookieName = "_sessionId";
    public static String pathToChromeDriver = retrieveProperty("pathToChromeDriver");


    private static String getBaseUrl() {
        String url = retrieveProperty("domain");
        System.out.println("https://".concat(url));
        return "https://".concat(url);

    }

    private static String getApiUrl() {
        String url = retrieveProperty("domain");
        return "https://api.".concat(url);
    }

    private static String getCookieDomain() {
        String url = retrieveProperty("domain");
        return ".api.".concat(url);
    }
}
