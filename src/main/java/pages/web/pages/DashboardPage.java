package pages.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.web.BasePage;

public class DashboardPage extends BasePage {


    @FindBy(xpath = "//*[@data-field-type='stripchat-link']")
    private WebElement defaultLinkLabel;

    @Step("Get Default Link value")
    public String getDefaultLinkValue() {
        return this.defaultLinkLabel.getText();
    }
}
