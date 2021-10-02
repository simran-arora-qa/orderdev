package com.tastemeta.orderdev.acceptancetests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.tastemeta.orderdev.step.definations"},
        features = "src/test/resources/features/",
        stepNotifications = true,
        plugin = {"pretty","json:target/cucumber.json","html:target/site/cucumber-pretty.html"},
        monochrome=true,
        tags = "not @ignore"
)
public class TestRunner {
}