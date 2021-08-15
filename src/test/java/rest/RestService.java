package rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.SneakyThrows;
import rest.dto.AssetLeverage;
import rest.dto.Token;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestService {

    private final static String BASE_URL = "https://api-mobile-live.hftrading.com.au";
    private final static String BASE_SERVICE = "/fms";
    private final static String BASIC_AUTHORIZATION = "Basic ODg4OTk5MDE2OnF3ZXJ0eTE2==";
    private final static String LOGIN = "571854";
    private final static String PASSWORD = "Trader33";

    /**
     * Static method which allows us to log request and response data
     * @see RestAssured#filters(Filter, Filter...)
     */
    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public Token getToken() {
        String body = String.format("grant_type=%s&username=%s&password=%s",
                "password",
                LOGIN,
                PASSWORD);

        return given()
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

    public void getOrderHistory(String accessToken, int asset, int orderType) {
        given()
                .auth()
                .oauth2(accessToken)
                .contentType("application/json")
                .when()
                .body(initHistoryBody(asset, orderType))
                .post(BASE_URL + BASE_SERVICE + "/history")
                .then()
                .assertThat()
                .contentType("application/json")
                .statusCode(200);
    }

    public void getOrderHistory_2(String accessToken, int asset, int orderType) {
        given()
                .auth()
                .oauth2(accessToken)
                .contentType("application/json")
                .when()
                .body(initHistoryBodyFromJson(asset, orderType))
                .post(BASE_URL + BASE_SERVICE + "/history")
                .then()
                .assertThat()
                .contentType("application/json")
                .statusCode(200);
    }

    private Map<String, Object> initHistoryBody(int asset, int orderType) {
        Map<String, Object> body = new HashMap<>();

        long endTime = System.currentTimeMillis();
        long startTime = endTime - 86400000 * 7;

        body.put("startTime", startTime);
        body.put("endTime", endTime);
        body.put("cmd", asset);
        body.put("type", orderType);
        return body;
    }

    @SneakyThrows
    private Map<String, Object> initHistoryBodyFromJson(int asset, int orderType) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> body = mapper.readValue(new File(
                "src/main/resources/history.json"), new TypeReference<Map<String, Object>>() {
        });
        body.put("cmd", asset);
        body.put("type", orderType);
        return body;
    }
}