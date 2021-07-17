package ui.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
@ResourceLock("ui.junit5.ServiceTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest extends BaseTest {

    @Test
    public void openServicePage() {
        $(byText("Service")).click();
        assertTrue($("#serveces").isDisplayed());
    }
}