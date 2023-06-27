Feature: Multiple cities

  Scenario: Book flight for multiple cities
    Given Launch application
    When Click on the MultiCity dropdown
    And Accept the popup
    And Select "Chennai" as a first city on FROM tab
    And Select "Goa" as a first city on To tab
    And Select "Goa" as a second city on FROM tab
    And Select "Patna" as a second city on To tab
    And Select "Patna" as a third city on FROM tab
    And Select "Jaipur" as a third city on To tab
    And Open calender and select the depart day "21"
    And select adult passenger count as "2"
    Then Count of the adult passenger should be "2 Adult"
    When select child passenger count as "1"
    Then Count of the child passenger should be "1 Child"
    When select infant passenger count as "2"
    Then Count of the infant passenger should be "2 Infant"
    When click on done
    Then Check if the drop down is disappeared after clicking Done
    When Select currency as "AED"
    And Click on search
