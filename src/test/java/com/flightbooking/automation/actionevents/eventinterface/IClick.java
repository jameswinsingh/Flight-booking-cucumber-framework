package com.flightbooking.automation.actionevents.eventinterface;


import com.flightbooking.automation.enums.LocatorType;

public interface IClick {

    public boolean clickElement(LocatorType locatorType, String locatorValue);
}
