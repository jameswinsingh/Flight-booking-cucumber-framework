package com.flightbooking.automation.utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reusable {

    public static boolean isDisplayed(WebDriver driver, WebElement ele) {

        boolean flag = false;
        flag = isElementPresent(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {

                System.out.println("PASS: The element is Displayed");

            } else {
                System.out.println("FAIL: The element is Displayed");
            }
        } else {
            System.out.println("Not displayed");

        }
        return flag;
    }

    public static boolean isElementPresent(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {

            System.out.println("PASS: The element is Displayed");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("FAIL: The element not Displayed");

            } else {
                System.out.println("Not displayed");
            }
        }
        return flag;
    }

    public static boolean isEnabled(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = isElementPresent(driver, ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                System.out.println("PASS: The element is enabled");
            } else {
                System.out.println("FAIL: The element not enabled");
            }
        } else {
            System.out.println("Not displayed");
        }
        return flag;
    }
}
