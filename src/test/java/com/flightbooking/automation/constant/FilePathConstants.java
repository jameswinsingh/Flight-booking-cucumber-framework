package com.flightbooking.automation.constant;

import java.io.File;

public class FilePathConstants {

    public static final String USER_DIR_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = USER_DIR_PATH + File.separator + "src" + File.separator + "test"
            + File.separator + "resources" + File.separator;
    public static final String LOCATORS_DIRECTORY = RESOURCES_PATH + "locators" + File.separator;
    public static final String FLIGHT_BOOKING_LOCATOR = LOCATORS_DIRECTORY + "FlightBookingLocators.properties";
    public static final String PACKAGE_HOLIDAY_LOCATOR = LOCATORS_DIRECTORY + "HolidayPackage.properties";
    public static final String CONFIG_FILE_PATH = RESOURCES_PATH + "config.properties";
    public static final String EXTENT_REPORT_PATH = USER_DIR_PATH + "/test-output/ExtentReport.html";

}
