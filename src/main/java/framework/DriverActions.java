package framework;

import framework.rest.AuthManagement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import static framework.Config.sessionCookieName;

@Log4j2
public class DriverActions {

    public static void open(String relativeUrl) {
        DriverFactory.getDriver().get(Config.baseUrl + relativeUrl);
    }


    public static void setAuthCookie() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(Config.apiURL);
        Cookie myCookie = new Cookie(sessionCookieName,
                AuthManagement.getAuthorizedSessionId(), Config.cookieDomain, "/", null);
        driver.manage().addCookie(myCookie);
    }
}
