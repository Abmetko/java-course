package rest;

import org.junit.jupiter.api.*;
import rest.dto.Token;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBase {

    private static BaseRestService restService;
    private static Token token;

    @BeforeAll
    static void setUp() {
        restService = new BaseRestService();
        token = restService.getToken();
    }

    @Test
    @Order(1)
    public void tokenTypeShouldBeEqualToExpectedValue() {
        assertEquals("bearer", token.getTokenType());
    }

    @Test
    @Order(2)
    public void symbolNameShouldBeEqualToExpectedValue() {
        assertEquals("ADAUSD", restService.getAssetLeverage(token.getAccessToken()).getSymbol());
    }
}