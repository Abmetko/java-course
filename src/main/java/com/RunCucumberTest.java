package com;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/print_feature/test.feature"},
        glue = "com.stepDefinitions")
public class RunCucumberTest {
}