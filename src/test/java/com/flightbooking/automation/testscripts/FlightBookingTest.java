package com.flightbooking.automation.testscripts;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/Features/OneWayTrip.feature"},
        glue = "com.flightbooking.automation.stepdef",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber/report.html"}
)

public class FlightBookingTest extends AbstractTestNGCucumberTests {

}
