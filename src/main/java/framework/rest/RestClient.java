package framework.rest;

import framework.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static framework.Config.sessionCookieName;


public class RestClient {
    String baseURI = Config.apiURL;

    public RequestSpecification requestSpecification() {
        return RestAssured.given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .filters(
                        new AllureRestAssured(),
                        new RequestLoggingFilter(),
                        new ResponseLoggingFilter());
    }

    public RequestSpecification requestSpecificationWithAuth() {
        return this.requestSpecification().cookie(sessionCookieName,
                AuthManagement.getAuthorizedSessionId());

    }
}
