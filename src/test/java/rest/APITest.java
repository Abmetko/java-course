package rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import rest.enums.OrderTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rest.enums.Assets.ADAUSD;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APITest {

    private static final RestService REST_SERVICE = new RestService();
    private static String token;

    @BeforeAll
    static void setUp() {
        token = REST_SERVICE.getToken().getAccessToken();
    }

    @Test
    public void symbolNameShouldBeEqualToExpectedValue() {
        assertEquals(ADAUSD.name(), REST_SERVICE.getAssetLeverage(token).getSymbol());
    }

    @Test
    public void getClosedOrderHistory() {
        REST_SERVICE.getOrderHistory(token, ADAUSD.getAssetType(), OrderTypes.CLOSED.getType());
    }

    @Test
    public void getOpenOrderHistory() {
        REST_SERVICE.getOrderHistory_2(token, ADAUSD.getAssetType(), OrderTypes.OPEN.getType());
    }
}