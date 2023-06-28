package com.flightbooking.automation.utils;


import com.flightbooking.automation.actionevents.events.Click;
import com.flightbooking.automation.actionevents.events.WaitElement;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReUsableMethods {

    Click click;
    WebDriver driver;
    PropertyParser propertyParser;
    WaitElement waitElement;

    public ReUsableMethods(WebDriver driver) {
        this.driver = driver;
        click = new Click(driver);
        waitElement = new WaitElement();
        propertyParser = new PropertyParser(FilePathConstants.MULTI_CITY_LOCATOR);
    }

    public void selectCountryOnFrom(String cityToSelect, String dropDownLoc, String allValueInDropDown) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(dropDownLoc));
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(allValueInDropDown)));

        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }
    }

    public void selectCityOnTo(String cityToSelect, String allCityNamesLoc) {
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(allCityNamesLoc)));
        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void datePicker(String day, String dateLoc, String allDateValues) {
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath(propertyParser.getPropertyValue(dateLoc))).click();
            List<WebElement> getDate = driver.findElements(By.xpath(propertyParser.getPropertyValue(allDateValues)));
            for (int i = 0; i < getDate.size(); i++) {
                if (getDate.get(i).getText().contains(day)) {
                    getDate.get(i).click();
                    break;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
