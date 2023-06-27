package com.flightbooking.automation.stepdef;

import com.flightbooking.automation.Pages.MultiCityBookingPage;
import com.flightbooking.automation.base.Base;
import io.cucumber.java.en.When;

public class MultiCityBookingDefinition extends Base {
    MultiCityBookingPage multiCityBookingPage;

    @When("Click on the MultiCity dropdown")
    public void click_on_the_multiCity_dropdown() {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.clickOnMultiCity();
    }

    @When("Accept the popup")
    public void accept_the_popup() {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.handlePopup();
    }


    @When("Select {string} as a first city on FROM tab")
    public void select_as_a_first_city_on_from_tab(String cityName) {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.selectCityOnFromTab(cityName);

    }

    @When("Select {string} as a first city on To tab")
    public void select_as_a_first_city_on_to_tab(String cityName) {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.selectCityOnToTab(cityName);

    }

    @When("Select {string} as a second city on FROM tab")
    public void select_as_a_second_city_on_from_tab(String cityName) {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.selectCityOnSecondFromTab(cityName);

    }

    @When("Select {string} as a second city on To tab")
    public void select_as_a_second_city_on_to_tab(String cityName) {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.selectCityOnSecondToTab(cityName);
    }

    @When("Select {string} as a third city on FROM tab")
    public void select_as_a_third_city_on_from_tab(String cityName) {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.selectCityOnThirdFromTab(cityName);
    }

    @When("Select {string} as a third city on To tab")
    public void select_as_a_third_city_on_to_tab(String cityName) {
        multiCityBookingPage = new MultiCityBookingPage(driver);
        multiCityBookingPage.selectCityOnThirdToTab(cityName);
    }

}
