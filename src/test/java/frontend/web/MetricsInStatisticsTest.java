package frontend.web;


import frontend.BaseTest;
import helpers.ApiHelper;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.web.PageManager;
import pages.web.pages.StatisticsPage;
import pages.web.steps.StaticticsSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MetricsInStatisticsTest extends BaseTest {

    @Test
    @TmsLink("TestCase Id 1")
    @Description("Check Click metric is updated in Statistics report after Click Event")
    public void checkClickMetricInStatisticsAfterEventTest() {
        ApiHelper apiHelper = new ApiHelper();
        //SetUp user view of report
        apiHelper.postFrontUserSettings();

        //Copy link on DashboardPage
        String linkToClick = PageManager.openDashboardPage().getDefaultLinkValue();

        //Open StatisticsPage and Get Click metric value
        StatisticsPage statisticsPage = PageManager.openStatisticsPage();
        statisticsPage.statisticsFiltersForm.clickRunReportButton();
        String initialClickMetric = statisticsPage.statisticsTable.getFistRow().getText();

        //Prepare expected value
        String expectedClickMetric = Integer.toString(Integer.parseInt(initialClickMetric) + 1);

        //Imitate the customer clicks the link
        apiHelper.click(linkToClick);

        //Get updated Click metric value

        String actualClickMetric = StaticticsSteps.runReportAndGetFirstRowValueWaitStep(statisticsPage, expectedClickMetric);
        //Extra assertion
        assertThat("click metric should be increased", actualClickMetric, equalTo(expectedClickMetric));
    }

    @Test
    @TmsLink("TestCase Id 1")
    @Description("Additional Test To Get Failed Result")
    public void additionalTestToGetFailedResultTest() {
        assert false;
    }


}


