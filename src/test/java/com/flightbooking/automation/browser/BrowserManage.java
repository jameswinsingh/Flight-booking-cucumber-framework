package com.flightbooking.automation.browser;


import com.flightbooking.automation.constant.ConfigPropertyKeys;
import com.flightbooking.automation.constant.FilePathConstants;
import com.flightbooking.automation.enums.WebDriverType;
import com.flightbooking.automation.utils.PropertyParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserManage {

    public WebDriver getWebDriver() {
        WebDriver driver = null;
        PropertyParser configPropertyParser = new PropertyParser(FilePathConstants.CONFIG_FILE_PATH);
        String automationDriverType = configPropertyParser.getPropertyValue(ConfigPropertyKeys.DRIVERTYPE);

        switch (WebDriverType.valueOf(automationDriverType)) {
            case firefox:
                driver = getFireFoxDriver();
                break;
        }
        return driver;
    }

    public WebDriver getFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;

    }

}
