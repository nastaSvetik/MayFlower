package pages.web.steps;

import framework.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.pages.StatisticsPage;

import java.time.Duration;
import java.util.Objects;

public class StaticticsSteps {

    @Step("Run Report and Get value")
    public static String runReportAndGetFirstRowValueWaitStep(StatisticsPage page, String expectedText) {
        final String[] actualText = new String[1];
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(100))
                .pollingEvery(Duration.ofSeconds(5))
                .until((ExpectedCondition<Boolean>) d -> {
                    page.statisticsFiltersForm.clickRunReportButton();
                    WebElement element = page.statisticsTable.getFistRow();

                    actualText[0] = element.getText();
                    return Objects.equals(actualText[0], expectedText);
                });
        return actualText[0];
    }
}
