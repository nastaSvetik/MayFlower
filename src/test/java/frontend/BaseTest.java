package frontend;

import framework.DriverActions;
import framework.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class

BaseTest {

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        DriverFactory.getDriver();
        DriverActions.setAuthCookie();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        DriverFactory.closeDriver();
    }
}
