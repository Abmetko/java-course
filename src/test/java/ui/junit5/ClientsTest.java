package ui.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
@ResourceLock("ui.junit5.ClientsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientsTest extends BaseTest {

    @Test
    @Order(1)
    public void openClientsPage() {
        $(byText("Clients")).click();
        Assumptions.assumeTrue($("#clients.portfolio").isDisplayed());
    }

    @Test
    @Order(2)
    public void openServicePage() {
        $(byText("Service")).click();
        assertTrue($("#serveces").isDisplayed());
    }
}