package pages.web.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.web.BasePage;

import java.util.List;

public class StatisticsTable extends BasePage {

    @Step("Get values in {0} column in table")
    public List<WebElement> getColumnValuesLabels(int columnIndex) {
        String xpath = "//*[@data-column-index='" + columnIndex + "' and not(contains(@role, 'header')) and not(contains(@data-last-row, 'true'))]";
        return super.driver.findElements(By.xpath(xpath));
    }

    @Step("Get upper value in first column in table")
    public WebElement getFistRow() {
        return getColumnValuesLabels(1).get(0);
    }


}
