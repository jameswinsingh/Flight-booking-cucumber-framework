package com.flightbooking.automation.stepdef;

import com.flightbooking.automation.Pages.FlightBookingPage;
import com.flightbooking.automation.base.Base;
import com.flightbooking.automation.utils.CaptureScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightBookingDefinition extends Base {
    Base base;
    FlightBookingPage bookingPage;
    String country;
    String adultPassengerCount;

    @After
    public void OnTestFail(Scenario method) {
        CaptureScreenshot captureScreenshot = new CaptureScreenshot();
        captureScreenshot.captureScreenshot(driver, method);
    }

    @Given("Launch application")
    public void launch_application() {
        base = new Base();
        base.launchApplication();
    }

    @When("Select county name as {string}")
    public void select_county_name_as(String countryName) throws InterruptedException {
        bookingPage = new FlightBookingPage(driver, test);
        country = bookingPage.selectCountryName(countryName);
    }

    @Then("User should select {string} as the country name")
    public void user_should_select_as_the_country_name(String countryName) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.validateCountry(country, countryName);

    }

    @When("Click on Round Trip radio button")
    public void click_on_round_trip_radio_button() {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectRoundTripRadioButton();
    }

    @When("Select {string} on FROM tab")
    public void select_on_from_tab(String cityToSelect) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectCountryOnFrom(cityToSelect);

    }

    @When("Select {string} on To tab")
    public void select_on_to_tab(String cityToSelect) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectCountryOnTo(cityToSelect);

    }

    @When("Open calender and select the depart day {string}")
    public void open_calender_and_select_the_depart_day(String dayToSelect) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectDepartDate(dayToSelect);

    }

    @When("Open calender and select the return day {string}")
    public void open_calender_and_select_the_return_day(String dayToSelect) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectReturnDate(dayToSelect);

    }

    @When("select adult passenger count as {string}")
    public void select_adult_passenger_count_as(String PassengerCount) {
        bookingPage = new FlightBookingPage(driver, test);
        adultPassengerCount = bookingPage.selectAdultPassenger(PassengerCount);

    }

    @Then("Count of the adult passenger should be {string}")
    public void count_of_the_adult_passenger_should_be(String passengerCount) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.validateAdultCount(adultPassengerCount, passengerCount);
    }

    @When("select child passenger count as {string}")
    public void select_child_passenger_count_as(String passengerCount) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectChildPassenger(passengerCount);

    }

    @Then("Count of the child passenger should be {string}")
    public void count_of_the_child_passenger_should_be(String passengerCount) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.validateChildCount(passengerCount);
    }

    @When("select infant passenger count as {string}")
    public void select_infant_passenger_count_as(String passengerCount) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectInfantPassenger(passengerCount);
    }

    @Then("Count of the infant passenger should be {string}")
    public void count_of_the_infant_passenger_should_be(String passengerCount) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.validateInfantCount(passengerCount);
    }

    @When("click on done")
    public void click_on_done() {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.clickDone();
        bookingPage.verifyPassengerDropDownIsClosed();
    }

    @Then("Check if the drop down is disappeared after clicking Done")
    public void check_if_the_drop_down_is_disappeared_after_clicking_done() {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.verifyPassengerDropDownIsClosed();
    }

    @When("Select currency as {string}")
    public void select_currency_as(String currencyType) {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.selectCurrency(driver, currencyType);
    }

    @When("Click on search")
    public void click_on_search() {
        bookingPage = new FlightBookingPage(driver, test);
        bookingPage.clickSearch();
    }

}
