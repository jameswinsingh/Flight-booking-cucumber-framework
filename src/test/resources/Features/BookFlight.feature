Feature: Book Flight Ticket

  Scenario: Book Flight
    Given Launch application
    When Select county name as "India"
    Then User should select "India" as the country name
    When Click on Round Trip radio button
    And Select "Chennai" on FROM tab
    And Select "Goa" on To tab
    And Open calender and select the depart day "21"
    And Open calender and select the return day "29"

