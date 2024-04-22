package framework.rest;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static framework.Config.sessionCookieName;
import static framework.rest.models.FrontAuth.getBaseUserCredentials;

public class AuthManagement {
    public String authorizedSessionId;
    private static AuthManagement auth;

    private AuthManagement() {
        this.authorizedSessionId = getAuthorizedSession();
    }

    public static String getAuthorizedSessionId() {
        if (auth == null) {
            auth = new AuthManagement();
        }
        return auth.authorizedSessionId;
    }


    @Step("Api: Authorize")
    private String getAuthorizedSession() {
        Response response = new RestClient().requestSpecification()
                .contentType("application/json")
                .body(getBaseUserCredentials())
                .when()
                .post("/front/auth")
                .then()
                .statusCode(200)
                .extract().response();

        return response.getDetailedCookie(sessionCookieName).getValue();
    }
}

