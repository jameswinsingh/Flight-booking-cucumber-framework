package com.flightbooking.automation.Pages;

import com.flightbooking.automation.actionevents.events.Click;
import com.flightbooking.automation.actionevents.events.InputTextField;
import com.flightbooking.automation.actionevents.events.WaitElement;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.LocatorType;
import com.flightbooking.automation.page.keys.FlightBookingKeys;
import com.flightbooking.automation.utils.PropertyParser;
import com.flightbooking.automation.verification.Verify;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightBookingPage {

    Click click;
    InputTextField textField;
    WaitElement waitElement;
    ExtentTest test;
    WebDriver driver;
    PropertyParser propertyParser;

    public FlightBookingPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        click = new Click(driver);
        textField = new InputTextField(driver);
        waitElement = new WaitElement();
        propertyParser = new PropertyParser(FilePathConstants.FLIGHT_BOOKING_LOCATORD);
    }


    public String selectCountryName(String countryName) {
        textField.enterText(LocatorType.XPATH, propertyParser.getPropertyValue(FlightBookingKeys.SELECT_COUNTRY_TEXT_BOX_LOC), countryName);
        List<WebElement> countryNameList = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.COUNTRY_DROPDOWN_VALUES_LOC)));

        String actualResult = " ";
        for (int i = 0; i < countryNameList.size(); i++) {
            if (countryNameList.get(i).getText().equalsIgnoreCase(countryName)) {
                actualResult = countryNameList.get(i).getText();
                countryNameList.get(i).click();
            }
        }
        return actualResult;
    }

    public void validateCountry(String actualResult, String countryName) {
        Verify.verifyString(actualResult, countryName);
    }

    public void selectRoundTripRadioButton() {
        try {
            String actualResult = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.ROUND_TRIP_RADIO_BUTTON_LOC))).getText();
            click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(FlightBookingKeys.ROUND_TRIP_RADIO_BUTTON_LOC));
            Verify.verifyString(actualResult, "Round Trip");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCountryOnFrom(String cityToSelect) {

        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(FlightBookingKeys.FROM_TAB_LOC));
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.GET_ALL_FROM_CITY_LOC)));

        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void selectCountryOnTo(String cityToSelect) {
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.GET_ALL_TO_CITY_LOC)));
        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void selectDepartDate(String day) {
        try {
            List<WebElement> getDate = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.GET_ALL_DEPART_DATES_LOC)));

            for (int i = 0; i < getDate.size(); i++) {
                if (getDate.get(i).getText().contains(day)) {
                    getDate.get(i).click();
                    break;
                }
            }

            String getSelectedDate = propertyParser.getPropertyValue(FlightBookingKeys.SELECTED_DATE_LOC);
            WebElement locator = driver.findElement(By.xpath(getSelectedDate));
            int expected = Integer.parseInt(day);
            String getText = locator.getText();
            String[] arr = getText.split(" ", 4);

            int actualResult = 0;
            for (int i = 0; i <= arr.length; i++) {
                actualResult = Integer.parseInt(arr[2]);
            }
            Verify.verifyInteger(actualResult, expected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectReturnDate(String returnDay) {
        try {
            Thread.sleep(2000);

            driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.RETURN_CALENDER_BUTTON_LOC))).click();
            List<WebElement> getDate = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.GET_ALL_RETURN_DATES_LOC)));
            for (WebElement webElement : getDate) {
                if (webElement.getText().contains(returnDay)) {
                    webElement.click();
                    break;
                }
            }

            String getSelectedReturnDate = propertyParser.getPropertyValue(FlightBookingKeys.SELECT_RETURN_DATE_LOC);
            WebElement locator = driver.findElement(By.xpath(getSelectedReturnDate));
            String getText = locator.getText();
            int expectedResult = Integer.parseInt(returnDay);
            String[] arr = getText.split(" ", 4);
            int actualResult = 0;
            for (int i = 0; i <= arr.length; i++) {
                actualResult = Integer.parseInt(arr[2]);
            }
            Verify.verifyInteger(actualResult, expectedResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

