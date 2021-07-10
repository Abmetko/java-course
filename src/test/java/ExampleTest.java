import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    @BeforeAll
    static void setUp() {
        timeout = 10000;
        startMaximized = true;
        browser = System.getenv("browser");
        open("https://wimix.com/");
    }

    @Test
    public void openServicePage() {
        $(byText("Service")).click();
        assertTrue($("#serveces").isDisplayed());
    }
}