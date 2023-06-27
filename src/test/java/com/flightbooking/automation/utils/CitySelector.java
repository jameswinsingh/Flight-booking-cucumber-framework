package com.flightbooking.automation.utils;


import com.flightbooking.automation.actionevents.events.Click;
import com.flightbooking.automation.actionevents.events.WaitElement;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.LocatorType;
import com.flightbooking.automation.messages.InfoMessage;
import com.flightbooking.automation.page.keys.FlightBookingKeys;
import com.flightbooking.automation.page.keys.MultiCityPageKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CitySelector {

    Click click;
    WebDriver driver;
    PropertyParser propertyParser;
    WaitElement waitElement;

    public CitySelector(WebDriver driver) {
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
}
