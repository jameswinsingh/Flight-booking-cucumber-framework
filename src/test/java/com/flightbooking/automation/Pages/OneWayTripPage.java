package com.flightbooking.automation.Pages;

import com.flightbooking.automation.actionevents.events.Click;
import com.flightbooking.automation.actionevents.events.InputTextField;
import com.flightbooking.automation.actionevents.events.WaitElement;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.LocatorType;
import com.flightbooking.automation.messages.InfoMessage;
import com.flightbooking.automation.page.keys.OneWayPageKeys;
import com.flightbooking.automation.utils.PropertyParser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OneWayTripPage {


    Click click;
    InputTextField textField;
    WaitElement waitElement;
    WebDriver driver;
    PropertyParser propertyParser;

    public OneWayTripPage(WebDriver driver) {
        this.driver = driver;
        click = new Click(driver);
        textField = new InputTextField(driver);
        waitElement = new WaitElement();
        propertyParser = new PropertyParser(FilePathConstants.ONE_WAY_LOCATOR);
    }

    public static Logger log = Logger.getLogger(OneWayTripPage.class);

    public void clickOneWayRadioButton() {
        log.info(InfoMessage.ONE_WAY_TRIP_INFO);
        boolean oneWayButton = driver.findElement(By.xpath(propertyParser.getPropertyValue(OneWayPageKeys.ONE_WAY_RADIO_BUTTON))).isSelected();
        System.out.println(oneWayButton);

        if (!oneWayButton) {
            click.clickElement(LocatorType.XPATH, propertyParser.getPropertyValue(OneWayPageKeys.ONE_WAY_RADIO_BUTTON));
        } else
            log.info(InfoMessage.ONE_WAY_TRIP_DEFAULT_SELECTED_INFO);

    }

    public void slideImage() {

        WebElement slider = driver.findElement(By.xpath("//div[@class='slider__item']/img"));

        try {
            Actions action = new Actions(driver);
            action.click(slider).build().perform();
            Thread.sleep(1000);
            for (int i = 0; i < 3; i++) {
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
