package ui.junit5;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({SetupExtension.class})
public class BaseTest extends JUnit5TestSuiteRunner {

    private static final String URL = "https://wimix.com/";

    @BeforeAll
    void setUp() {
        timeout = 10000;
        startMaximized = true;
        browser = "chrome";
        open(URL);
    }

    @AfterAll
    void tearDown() {
        closeWebDriver();
    }

    @After
    public void sleep() {
        Selenide.sleep(1000);
    }
}