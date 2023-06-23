package com.flightbooking.automation.actionevents.events;

import com.flightbooking.automation.actionevents.eventinterface.IWaitElement;
import com.flightbooking.automation.enums.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitElement implements IWaitElement {

    WebDriver driver;

    public void waitForElement(LocatorType locatorType, String locatorValue) {
        WebDriverWait wait;
        try {
            switch (locatorType) {
                case XPATH:
                    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                    break;
                case ID:
                    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                    break;
                case NAME:
                    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                    break;
                case CLASS:
                    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
                    break;
                case TAG:
                    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
                    break;
                case CSS:
                    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
    }

}

