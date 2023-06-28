package com.flightbooking.automation.stepdef;

import com.flightbooking.automation.Pages.OneWayTripPage;
import com.flightbooking.automation.base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class OneWayTripDefinition extends Base {

    @When("Click on One Way Trip radio button")
    public void click_on_one_way_trip_radio_button() {
        OneWayTripPage oneWayTripPage = new OneWayTripPage(driver);
        oneWayTripPage.clickOneWayRadioButton();
    }

    @And("slide up to third image")
    public void slideUpToThirdImage() {
        OneWayTripPage oneWayTripPage = new OneWayTripPage(driver);
        oneWayTripPage.slideImage();
    }
}
