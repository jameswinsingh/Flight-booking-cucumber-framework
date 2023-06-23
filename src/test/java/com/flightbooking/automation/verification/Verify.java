package com.flightbooking.automation.verification;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

public class Verify {
    public static boolean verifyString(String actual, String expected) {
        boolean status = false;
        try {
            Assert.assertEquals(actual, expected);
            status = true;
            System.out.println("PASS:  Actual Result :: " + actual + " == " + " Expected Result :: " + expected );
        } catch (AssertionError assertionError) {
            System.out.println("FAIL:  Actual Result :: " + actual + " == " + " Expected Result :: " + expected );
        }
        return status;
    }

    public static boolean verifyInteger(int actual, int expected) {
        boolean status = false;
        try {
            Assert.assertEquals(actual, expected);
            status = true;
            System.out.println("PASS:  Actual Result :: " + actual + " == " + " Expected Result :: " + expected );
        } catch (AssertionError assertionError) {
            System.out.println("FAIL:  Actual Result :: " + actual + " == " + " Expected Result :: " + expected );
        }
        return status;
    }
}


// THIS ASSERTION IS USING LOG4J
//    public static boolean verifyString(String actualText, String expectedText, String verificationStepMessage) {
//        Log.info(verificationStepMessage);
//
//        boolean status = false;
//        try {
//            Assert.assertEquals(actualText, expectedText);
//            status = true;
//
//            Log.info("PASS: |" +" Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
//
//        } catch (AssertionError assertionError) {
//            Log.error("FAIL: |" +" Actual Result :: " + expectedText + " == " + " Expected Result :: " + actualText);
//        }
//        return status;
//    }



