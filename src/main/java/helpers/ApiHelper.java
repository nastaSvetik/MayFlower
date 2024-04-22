package helpers;


import framework.rest.RestClient;
import io.qameta.allure.Step;

import static framework.rest.models.FrontUserSettings.getSettingsClickColumnOnly;


public class ApiHelper {
    private final RestClient restClient = new RestClient();

    @Step("Api: postFrontUserSettings")
    public void postFrontUserSettings() {


        restClient.requestSpecificationWithAuth()
                .body(getSettingsClickColumnOnly())
                .when()
                .post("/front/userSettings")
                .then()
                .statusCode(200);

    }

    @Step("Api: Click link")
    public void click(String link) {
        restClient.requestSpecification()
                .when()
                .get(link).then()
                .statusCode(200);

    }
}
