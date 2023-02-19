package com.academy.techcenture.stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/academy/techcenture/features",
        glue = "com/academy/techcenture/stepDefinitions")
public class TestRunner {
}
