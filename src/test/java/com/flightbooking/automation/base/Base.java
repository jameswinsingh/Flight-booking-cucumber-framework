package com.flightbooking.automation.base;

import com.flightbooking.automation.browser.BrowserManage;
import com.flightbooking.automation.constant.ConfigPropertyKeys;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.utils.PropertyParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class Base {
    PropertyParser configPropertyParser = new PropertyParser(FilePathConstants.CONFIG_FILE_PATH);
    public static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports extent;

    public void launchApplication() {
        BrowserManage browserManager = new BrowserManage();
        driver = browserManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to(configPropertyParser.getPropertyValue(ConfigPropertyKeys.URL));
    }

    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports(FilePathConstants.EXTENT_REPORT_PATH);
    }

    @AfterMethod
    public void afterMethod() {
        extent.endTest(test);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        test = extent.startTest((this.getClass().getSimpleName() + "::" + method.getName()), method.getName());
    }

    @AfterClass
    public void afterClass() {
        extent.flush();
        extent.close();
        driver.quit();
    }

//    @AfterSuite
//    public void afterSuite() {
//        extent.flush();
//        extent.close();
//    }
}
