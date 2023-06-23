package com.flightbooking.automation.actionevents.eventinterface;


import com.flightbooking.automation.enums.LocatorType;

public interface IWaitElement {
    /**
     * This method is to check whether the element is available or not.
     *
     */
    public void waitForElement(LocatorType locatorType, String locatorValue);


}
