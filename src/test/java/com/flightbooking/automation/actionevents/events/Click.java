package com.flightbooking.automation.actionevents.events;


import com.flightbooking.automation.actionevents.eventinterface.IClick;
import com.flightbooking.automation.enums.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Click implements IClick {

    WebDriver driver;

    public Click(WebDriver driver) {
        this.driver = driver;
    }

    public boolean clickElement(LocatorType locatorType, String locatorValue) {
        boolean clickStatus = false;
        try {
            switch (locatorType) {
                case XPATH:
                    driver.findElement(By.xpath(locatorValue)).click();
                    clickStatus = true;
                    break;

                case ID:
                    driver.findElement(By.id(locatorValue)).click();
                    clickStatus = true;
                    break;

                case NAME:
                    driver.findElement(By.name(locatorValue)).click();
                    clickStatus = true;
                    break;
                case CLASS:
                    driver.findElement(By.className(locatorValue)).click();
                    clickStatus = true;
                    break;
                case TAG:
                    driver.findElement(By.tagName(locatorValue)).click();
                    clickStatus = true;
                    break;
                case CSS:
                    driver.findElement(By.cssSelector(locatorValue)).click();
                    clickStatus = true;
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Exception Occurred \n" + exception.fillInStackTrace());
        }
        return clickStatus;
    }


}
