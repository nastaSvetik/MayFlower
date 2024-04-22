package pages.web;


import framework.DriverActions;
import io.qameta.allure.Step;
import pages.web.pages.DashboardPage;
import pages.web.pages.StatisticsPage;

public class PageManager {

    @Step("Open Dashboard Page")
    public static DashboardPage openDashboardPage() {
        DriverActions.open("/overview/dashboard");
        return new DashboardPage();
    }

    @Step("Open Statistics Page")
    public static StatisticsPage openStatisticsPage() {
        DriverActions.open("/analytics/statistics");
        return new StatisticsPage();
    }

}
