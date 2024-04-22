package pages.web.components;

import helpers.EnhancedClick;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.web.BasePage;


public class StatisticsFiltersForm extends BasePage {
    @FindBy(xpath = "//*[text()='Run report']")
    private WebElement runReportButton;


    @Step("Click Run Report Button")
    public void clickRunReportButton() {
        EnhancedClick.click(this.runReportButton);
    }
}
