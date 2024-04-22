package framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;
    private static String pathToDriver = Config.pathToChromeDriver;


    private DriverFactory() {
    }

    private static void initDriver() {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            initDriver();
        }
        return driver;
    }

    public static void closeDriver() {
//    if (Objects.nonNull(driver)){
//        driver.quit();
//      }
    }
}
