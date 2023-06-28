package com.flightbooking.automation.Pages;

import com.flightbooking.automation.actionevents.events.Click;
import com.flightbooking.automation.actionevents.events.InputTextField;
import com.flightbooking.automation.actionevents.events.WaitElement;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.LocatorType;
import com.flightbooking.automation.messages.InfoMessage;
import com.flightbooking.automation.messages.VerifyMessage;
import com.flightbooking.automation.page.keys.MultiCityPageKeys;
import com.flightbooking.automation.utils.PropertyParser;
import com.flightbooking.automation.utils.ReUsableMethods;
import com.flightbooking.automation.verification.Verify;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiCityBookingPage {

    Click click;
    InputTextField textField;
    WaitElement waitElement;
    WebDriver driver;
    PropertyParser propertyParser;
    ReUsableMethods reUsableMethods;

    public MultiCityBookingPage(WebDriver driver) {
        this.driver = driver;
        click = new Click(driver);
        textField = new InputTextField(driver);
        waitElement = new WaitElement();
        propertyParser = new PropertyParser(FilePathConstants.MULTI_CITY_LOCATOR);
    }

    public static Logger log = Logger.getLogger(MultiCityBookingPage.class);

    public void clickOnMultiCity() {
        try {
            log.info(InfoMessage.SELECT_MULTI_CITY_TRIP_INFO);
            String actualResult = driver.findElement(By.xpath(propertyParser.getPropertyValue(MultiCityPageKeys.MULTI_CITY_RADIO_BUTTON_LOC))).getText();
            click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(MultiCityPageKeys.MULTI_CITY_RADIO_BUTTON_LOC));

            log.info(VerifyMessage.VERIFY_TRIP_TYPE);
            Verify.verifyString(actualResult, MultiCityPageKeys.TRIP_TYPE_LOC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handlePopup() {
        log.info(InfoMessage.POP_UP_INFO);
        waitElement.waitForElement(LocatorType.XPATH, propertyParser.getPropertyValue(MultiCityPageKeys.POPUP_LOC));
        driver.findElement(By.xpath(propertyParser.getPropertyValue(MultiCityPageKeys.POPUP_LOC))).click();
    }


    public void selectCityOnFromTab(String cityName) {
        log.info(InfoMessage.FIRST_FROM_CITY_INFO + cityName);
        reUsableMethods = new ReUsableMethods(driver);
        reUsableMethods.selectCountryOnFrom(cityName, MultiCityPageKeys.FROM_DROP_DOWN_ONE_LOC, MultiCityPageKeys.ALL_FROM_DROP_DOWN_CITY_LOC);


    }

    public void selectCityOnToTab(String cityName) {
        log.info(InfoMessage.FIRST_TO_CITY_INFO + cityName);
        reUsableMethods = new ReUsableMethods(driver);
        reUsableMethods.selectCityOnTo(cityName, MultiCityPageKeys.ALL_FROM_DROP_DOWN_CITY_LOC);

    }

    public void selectDateForFirstCity(String day) {
        log.info(InfoMessage.DATE_INFO + day);
        reUsableMethods = new ReUsableMethods(driver);
        reUsableMethods.datePicker(day, MultiCityPageKeys.CITY_ONE_CALENDER_LOC, MultiCityPageKeys.ALL_DATE_IN_CALENDER_LOC);
    }

    public void selectCityOnSecondFromTab(String cityName) {
        log.info(InfoMessage.SECOND_FROM_CITY_INFO + cityName);
        reUsableMethods = new ReUsableMethods(driver);
        reUsableMethods.selectCountryOnFrom(cityName, MultiCityPageKeys.FROM_DROP_DOWN_TWO_LOC, MultiCityPageKeys.ALL_FROM_DROP_DOWN_CITY_LOC);

    }

    public void selectCityOnSecondToTab(String cityName) {
        log.info(InfoMessage.SECOND_TO_CITY_INFO + cityName);
        reUsableMethods = new ReUsableMethods(driver);
        reUsableMethods.selectCityOnTo(cityName, MultiCityPageKeys.ALL_FROM_DROP_DOWN_CITY_LOC);

    }

    public void selectCityOnThirdFromTab(String cityName) {
        log.info(InfoMessage.THIRD_FROM_CITY_INFO + cityName);
        reUsableMethods = new ReUsableMethods(driver);
        reUsableMethods.selectCountryOnFrom(cityName, MultiCityPageKeys.FROM_DROP_DOWN_THREE_LOC, MultiCityPageKeys.ALL_FROM_DROP_DOWN_CITY_LOC);

    }

    public void selectCityOnThirdToTab(String cityName) {
        log.info(InfoMessage.THIRD_TO_CITY_INFO + cityName);
        reUsableMethods = new ReUsableMethods(driver);
        reUsableMethods.selectCityOnTo(cityName, MultiCityPageKeys.ALL_FROM_DROP_DOWN_CITY_LOC);

    }


}
