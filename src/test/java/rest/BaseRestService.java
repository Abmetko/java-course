package rest;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import rest.dto.AssetLeverage;
import rest.dto.Token;

import static io.restassured.RestAssured.given;

public class BaseRestService {

    private final static String BASE_URL = "https://api-mobile-live.hftrading.com.au";
    private final static String BASE_SERVICE = "/fms";
    private final static String BASIC_AUTHORIZATION = "Basic ODg4OTk5MDE2OnF3ZXJ0eTE2==";
    private final static String LOGIN = "571854";
    private final static String PASSWORD = "Trader33";

    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public Token getToken() {
        String body = String.format("grant_type=%s&username=%s&password=%s",
                "password",
                LOGIN,
                PASSWORD);

        return given()
                .with()
                .contentType("application/x-www-form-urlencoded")
                .header("Authorization", BASIC_AUTHORIZATION)
                .when()
                .body(body)
                .post(BASE_URL + BASE_SERVICE + "/auth/oauth/token")
                .then()
                .assertThat()
                .contentType("application/json")
                .statusCode(200)
                .extract()
                .as(Token.class);
    }

    public AssetLeverage getAssetLeverage(String accessToken) {
        return given()
                .with()
                .auth()
                .oauth2(accessToken)
                .contentType("application/json")
                .when()
                .body("{\"symbol\":\"ADAUSD\"}")
                .post(BASE_URL + BASE_SERVICE + "/leverage")
                .then()
                .assertThat()
                .contentType("application/json")
                .statusCode(200)
                .extract()
                .as(AssetLeverage.class);
    }
}