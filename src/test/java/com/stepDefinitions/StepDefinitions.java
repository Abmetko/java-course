package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import rest.RestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rest.enums.Assets.ADAUSD;
import static rest.enums.OrderTypes.CLOSED;
import static rest.enums.OrderTypes.OPEN;

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