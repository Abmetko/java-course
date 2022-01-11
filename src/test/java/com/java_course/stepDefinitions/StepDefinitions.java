package com.java_course.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.java_course.rest.RestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.java_course.rest.enums.Assets.ADAUSD;
import static com.java_course.rest.enums.OrderTypes.CLOSED;
import static com.java_course.rest.enums.OrderTypes.OPEN;

public class StepDefinitions {

    private static final RestService REST_SERVICE = new RestService();
    private static String token;

    @Given("get access token")
    public void getAccessToken() {
        token = REST_SERVICE.getToken().getAccessToken();
    }

    @Then("number of closed orders equals to {string}")
    public void checkNumberOfClosedOrders(String number) {
        int numberOfClosedOrders = REST_SERVICE.getOrderHistory(token, ADAUSD.getAssetType(), CLOSED.getType()).length;
        assertEquals(Integer.parseInt(number), numberOfClosedOrders, "Number of closed orders is incorrect");
    }

    @Then("number of open orders equals to {string}")
    public void checkNumberOfOpenOrders(String number) {
        int numberOfOpenOrders = REST_SERVICE.getOrderHistory_2(token, ADAUSD.getAssetType(), OPEN.getType()).length;
        assertEquals(Integer.parseInt(number), numberOfOpenOrders, "Number of open orders is incorrect");
    }
}