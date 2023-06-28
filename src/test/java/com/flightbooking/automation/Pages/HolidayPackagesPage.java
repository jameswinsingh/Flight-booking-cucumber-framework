package com.flightbooking.automation.Pages;

import com.flightbooking.automation.actionevents.events.Click;
import com.flightbooking.automation.actionevents.events.InputTextField;
import com.flightbooking.automation.actionevents.events.WaitElement;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.LocatorType;
import com.flightbooking.automation.messages.InfoMessage;
import com.flightbooking.automation.page.keys.HolidayPackagesKeys;
import com.flightbooking.automation.utils.PropertyParser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HolidayPackagesPage {

    Click click;
    InputTextField textField;
    WaitElement waitElement;
    WebDriver driver;
    PropertyParser propertyParser;

    public HolidayPackagesPage(WebDriver driver) {
        this.driver = driver;
        click = new Click(driver);
        textField = new InputTextField(driver);
        waitElement = new WaitElement();
        propertyParser = new PropertyParser(FilePathConstants.PACKAGE_HOLIDAY_LOCATOR);
    }

    public static Logger log = Logger.getLogger(HolidayPackagesPage.class);

    public void clickHolidayPackagesTab() {
        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.HOLIDAY_PACKAGE_LOC));
    }

    public void selectCityFromDestination(String cityToSelect) {
        log.info(InfoMessage.DEPARTURE_CITY_INFO + cityToSelect);
        waitElement.waitForElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.DESTINATION_DROP_DOWN_LOC));
        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.DESTINATION_DROP_DOWN_LOC));
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(HolidayPackagesKeys.ALL_DROP_DOWN_VALUE_LOC)));

        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void selectDepartureCity(String cityToSelect) {
        log.info(InfoMessage.DEPARTURE_CITY_INFO + cityToSelect);
        waitElement.waitForElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.DEPARTURE_DROP_DOWN_LOC));
        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.DEPARTURE_DROP_DOWN_LOC));
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(HolidayPackagesKeys.ALL_DROP_DOWN_VALUE_LOC)));

        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void selectReturnDate(String cityToSelect) {

        log.info(InfoMessage.DEPARTURE_CITY_INFO + cityToSelect);
        waitElement.waitForElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.RETURN_DROP_DOWN_LOC));
        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.RETURN_DROP_DOWN_LOC));
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(HolidayPackagesKeys.ALL_DROP_DOWN_VALUE_LOC)));

        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void clickOnDepartCalender() {
        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(HolidayPackagesKeys.CALENDER_LOC));
    }

    public void clickSearch() {

        log.info(InfoMessage.CLICK_SEARCH_INFO);
//        String searchButton = propertyParser.getPropertyValue(HolidayPackagesKeys.SEARCH_LOC);
//        click.clickElement(LocatorType.XPATH, searchButton);

    }

}
