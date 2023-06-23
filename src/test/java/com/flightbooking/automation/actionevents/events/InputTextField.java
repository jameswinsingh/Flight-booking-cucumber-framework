package com.flightbooking.automation.actionevents.events;


import com.flightbooking.automation.enums.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputTextField {

    WebDriver driver;

    public InputTextField(WebDriver driver) {
        this.driver = driver;
    }

    public boolean enterText(LocatorType locatorType, String  locatorValue, String text) {
        boolean inputTextEntryStatus = false;
        try {
            switch (locatorType) {
                case XPATH:
                    driver.findElement(By.xpath(locatorValue)).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case ID:
                    driver.findElement(By.id(locatorValue)).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case NAME:
                    driver.findElement(By.name(locatorValue)).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case CLASS:
                    driver.findElement(By.className(locatorValue)).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case TAG:
                    driver.findElement(By.tagName(locatorValue)).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
                case CSS:
                    driver.findElement(By.cssSelector(locatorValue)).sendKeys(text);
                    inputTextEntryStatus = true;
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.getMessage());
        }
        return inputTextEntryStatus;
    }
}
