package com.flightbooking.automation.stepdef;

import com.flightbooking.automation.Pages.HolidayPackagesPage;
import com.flightbooking.automation.base.Base;
import com.flightbooking.automation.utils.CaptureScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;

public class HolidayPackagesDefinition extends Base {

    @After
    public void OnTestFail(Scenario method) {
        CaptureScreenshot captureScreenshot = new CaptureScreenshot();
        captureScreenshot.captureScreenshot(driver, method);
    }

//    @AfterAll
//    public void tearDown()
//    {
//        driver.quit();
//    }
    HolidayPackagesPage holidayPackagesPage;

    @When("Click on Holiday Packages tab")
    public void click_on_holiday_packages_tab() {
        holidayPackagesPage = new HolidayPackagesPage(driver);
        holidayPackagesPage.clickHolidayPackagesTab();

    }

    @When("Select {string} from destination city")
    public void select_from_destination_city(String cityName) {
        holidayPackagesPage = new HolidayPackagesPage(driver);
        holidayPackagesPage.selectCityFromDestination(cityName);

    }

    @When("Select {string} from departure city")
    public void select_from_departure_city(String cityName) {
        holidayPackagesPage = new HolidayPackagesPage(driver);
        holidayPackagesPage.selectDepartureCity(cityName);

    }

    @When("Select {string} from Return")
    public void select_from_return(String cityName) {
        holidayPackagesPage = new HolidayPackagesPage(driver);
        holidayPackagesPage.selectReturnDate(cityName);
        holidayPackagesPage.clickOnDepartCalender();

    }

    @When("Click on the search")
    public void click_on_the_search() {
        holidayPackagesPage = new HolidayPackagesPage(driver);
        holidayPackagesPage.clickSearch();

    }
}
