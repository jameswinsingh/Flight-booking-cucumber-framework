package com.flightbooking.automation.stepdef;

import com.flightbooking.automation.Pages.FlightBookingPage;
import com.flightbooking.automation.base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FlightBookingDefinition extends Base{
    Base base;
    FlightBookingPage bookingPage;
    String country;

    @Given("Launch application")
    public void launch_application() {
        base = new Base();
        base.launchApplication();
    }

    @When("Select county name as {string}")
    public void select_county_name_as(String countryName) {
        bookingPage = new FlightBookingPage(driver, test);
        country = bookingPage.selectCountryName(countryName);
    }

    @Then("User should select {string} as the country name")
    public void user_should_select_as_the_country_name(String countryName) {
        bookingPage= new FlightBookingPage(driver,test);
        bookingPage.validateCountry(country, countryName);

    }

    @When("Click on Round Trip radio button")
    public void click_on_round_trip_radio_button() {
        bookingPage= new FlightBookingPage(driver,test);
        bookingPage.selectRoundTripRadioButton();
    }

    @When("Select {string} on FROM tab")
    public void select_on_from_tab(String cityToSelect) {
        bookingPage= new FlightBookingPage(driver,test);
        bookingPage.selectCountryOnFrom(cityToSelect);

    }

    @When("Select {string} on To tab")
    public void select_on_to_tab(String cityToSelect) {
        bookingPage= new FlightBookingPage(driver,test);
        bookingPage.selectCountryOnTo(cityToSelect);

    }

    @When("Open calender and select the depart day {string}")
    public void open_calender_and_select_the_depart_day(String dayToSelect) {
        bookingPage= new FlightBookingPage(driver,test);
        bookingPage.selectDepartDate(dayToSelect);

    }

    @When("Open calender and select the return day {string}")
    public void open_calender_and_select_the_return_day(String dayToSelect) {
        bookingPage= new FlightBookingPage(driver,test);
        bookingPage.selectReturnDate(dayToSelect);

    }


}
