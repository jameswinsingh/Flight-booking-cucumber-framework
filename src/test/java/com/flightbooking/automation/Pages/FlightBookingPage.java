package com.flightbooking.automation.Pages;

import com.flightbooking.automation.actionevents.events.Click;
import com.flightbooking.automation.actionevents.events.InputTextField;
import com.flightbooking.automation.actionevents.events.WaitElement;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.LocatorType;
import com.flightbooking.automation.messages.InfoMessage;
import com.flightbooking.automation.messages.VerifyMessage;
import com.flightbooking.automation.page.keys.FlightBookingKeys;
import com.flightbooking.automation.utils.PropertyParser;
import com.flightbooking.automation.utils.Reusable;
import com.flightbooking.automation.verification.Verify;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
        propertyParser = new PropertyParser(FilePathConstants.FLIGHT_BOOKING_LOCATOR);
    }

    public static Logger log = Logger.getLogger(FlightBookingPage.class);

    public String selectCountryName(String countryName) throws InterruptedException {
        log.info(InfoMessage.SELECT_COUNTRY_NAME_INFO + countryName);
        textField.enterText(LocatorType.XPATH, propertyParser.getPropertyValue(FlightBookingKeys.SELECT_COUNTRY_TEXT_BOX_LOC), countryName);
        Thread.sleep(3000);
        List<WebElement> countryNameList = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.COUNTRY_DROPDOWN_VALUES_LOC)));

        String actualResult = " ";
        for (int i = 1; i < countryNameList.size(); i++) {
            if (countryNameList.get(i).getText().contains(countryName)) {
                actualResult = countryNameList.get(i).getText();
                countryNameList.get(i).click();
            }
        }
        System.out.println(actualResult);
        return actualResult;
    }

    public void validateCountry(String actualResult, String countryName) {
        log.info(VerifyMessage.VERIFY_SELECTED_COUNTRY + countryName);
        Verify.verifyString(actualResult, countryName);
    }

    public void selectRoundTripRadioButton() {
        try {
            log.info(InfoMessage.SELECT_ROUND_TRIP_INFO);
            String actualResult = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.ROUND_TRIP_RADIO_BUTTON_LOC))).getText();
            click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(FlightBookingKeys.ROUND_TRIP_RADIO_BUTTON_LOC));

            log.info(VerifyMessage.VERIFY_TRIP_TYPE);
            Verify.verifyString(actualResult, "Round Trip");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCountryOnFrom(String cityToSelect) {

        log.info(InfoMessage.DEPARTURE_CITY_INFO + cityToSelect);
        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(FlightBookingKeys.FROM_TAB_LOC));
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.GET_ALL_FROM_CITY_LOC)));

        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void selectCountryOnTo(String cityToSelect) {
        log.info(InfoMessage.ARRIVAL_CITY_INFO + cityToSelect);
        List<WebElement> getCityValues = driver.findElements(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.GET_ALL_TO_CITY_LOC)));
        for (int i = 0; i < getCityValues.size(); i++) {
            if (getCityValues.get(i).getText().contains(cityToSelect)) {
                getCityValues.get(i).click();
            }
        }

    }

    public void selectDepartDate(String day) {

        log.info(InfoMessage.DEPART_CALENDER_INFO + day);
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

            log.info(VerifyMessage.VERIFY_DEPART_DATE + actualResult);
            Verify.verifyInteger(actualResult, expected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectReturnDate(String returnDay) {

        log.info(InfoMessage.SELECT_RETURN_DATE_INFO + returnDay);
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

            log.info(VerifyMessage.VERIFY_RETURN_DATE + actualResult);
            Verify.verifyInteger(actualResult, expectedResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String selectAdultPassenger(String passengerCount) {

        log.info(InfoMessage.ADULT_INFO + passengerCount);

        click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(FlightBookingKeys.ADULT_PASSENGER_DROPDOWN_LOC));
        WebElement adultLocator = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.ADULT_INCREMENT_BUTTON_LOC)));
        int passenger = Integer.parseInt(passengerCount);

        int i = 1;
        while (i < passenger) {
            adultLocator.click();
            i++;
        }
        String actualResult = driver.findElement(By.xpath("//div[@class='paxinfo']")).getText();
        return actualResult;

    }

    public void validateAdultCount(String actualAdultPassengerCount, String expectedText) {
        log.info(VerifyMessage.VERIFY_ADULT_COUNT + expectedText);
        Verify.verifyString(actualAdultPassengerCount, expectedText);
    }


    public void selectChildPassenger(String passengerCount) {

        log.info(InfoMessage.CHILD_INFO + passengerCount);
        WebElement addCount = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.CHILD_INCREMENT_BUTTON_LOC)));
        int childPassenger = Integer.parseInt(passengerCount);

        int j = 0;
        while (j < childPassenger) {
            addCount.click();
            j++;
        }

    }

    public void validateChildCount(String expectedText) {

        String passengerCountLocator = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.TOTAL_PASSENGER_LIST_LOC))).getText();
        String[] splitString = passengerCountLocator.split(",");

        String actualResult = "";
        for (int i = 0; i <= splitString.length; i++) {
            actualResult = splitString[1];
        }
        actualResult = actualResult.trim();

        log.info(VerifyMessage.VERIFY_CHILD_COUNT + expectedText);
        Verify.verifyString(actualResult, expectedText);
    }

    public void selectInfantPassenger(String passengerCount) {

        log.info(InfoMessage.INFANT_INFO + passengerCount);
        WebElement addInfantCount = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.INFANT_INCREMENT_BUTTON_LOC)));
        int addCountInfant = Integer.parseInt(passengerCount);

        int k = 0;
        while (k < addCountInfant) {
            addInfantCount.click();
            k++;
        }

    }

    public void validateInfantCount(String expectedText) {
        String passengerCountLocator = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.TOTAL_PASSENGER_LIST_LOC))).getText();
        String[] splitString = passengerCountLocator.split(",");

        String actualResult = "";
        for (int i = 0; i <= splitString.length; i++) {
            actualResult = splitString[2];
        }
        actualResult = actualResult.trim();

        log.info(VerifyMessage.VERIFY_INFANT_COUNT + expectedText);
        Verify.verifyString(actualResult, expectedText);
    }

    public void clickDone() {

        log.info(InfoMessage.CLICK_DONE_INFO);
        String doneButton = propertyParser.getPropertyValue(FlightBookingKeys.DONE_LOC);
        WebElement doneButtonLocator = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.DONE_LOC)));
        Reusable.isDisplayed(driver, doneButtonLocator);
        click.clickElement(LocatorType.XPATH, doneButton);

    }

    public void verifyPassengerDropDownIsClosed() {
        log.info(VerifyMessage.VERIFY_PASSENGER_DROPDOWN);
        WebElement getAttValue = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.DONE_LOC)));
        if (!getAttValue.isDisplayed()) {
            System.out.println("PASS: The drop down is closed");
        } else
            System.out.println("The drop down is not closed");
    }

    public void selectCurrency(WebDriver driver, String currencyName) {

        log.info(InfoMessage.SELECT_CURRENCY_INFO + currencyName);
        WebElement currency = driver.findElement(By.xpath(propertyParser.getPropertyValue(FlightBookingKeys.CURRENCY_DROPDOWN_LOC)));
        Select dropCountry = new Select(currency);
        dropCountry.selectByVisibleText(currencyName);

    }

    public void clickSearch() {

        log.info(InfoMessage.CLICK_SEARCH_INFO);
        String searchButton = propertyParser.getPropertyValue(FlightBookingKeys.SEARCH_BUTTON);
        click.clickElement(LocatorType.XPATH, searchButton);

    }


}

