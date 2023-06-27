package com.flightbooking.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaptureScreenshot {
    public void captureScreenshot(WebDriver driver, Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "FailedTestScreenshot");
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String filePath = System.getProperty("user.dir") + "\\screenshots\\" + screenshotName + ".png";
            System.out.println(filePath);
            try {
                Files.write(Paths.get(filePath), screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
