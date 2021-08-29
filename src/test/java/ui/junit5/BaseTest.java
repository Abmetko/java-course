package ui.junit5;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith({SetupExtension.class})
public class BaseTest extends JUnit5TestSuite {

    public static final String URL = "https://wimix.com/";

    @BeforeAll
    static void setUp() {
        timeout = 10000;
        startMaximized = true;
        browser = "chrome";
        open(URL);
        System.out.println("setup: " + LocalDateTime.now());
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
        System.out.println("tear down: " + LocalDateTime.now());
    }

    @After
    public void sleep() {
        Selenide.sleep(1000);
    }
}