Feature: One Way Trip

  Scenario: Book Flight for one way trip
    Given Launch application
    When Select county name as "India"
    Then User should select "India" as the country name
    When Click on One Way Trip radio button
    And Select "Madurai" on FROM tab
    And Select "Tirupati" on To tab
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
    And slide up to third image
    And Click on search
    And close the browser