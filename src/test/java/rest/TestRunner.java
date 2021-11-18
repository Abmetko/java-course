package rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(APITest.class)
public class TestRunner {

    @BeforeAll
    static void setUp1() {
        System.out.println("HELLO");
    }
}