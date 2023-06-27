Feature: Holiday Package

  Scenario: Book Flight on holiday package
    Given Launch application
    When Click on Holiday Packages tab
    And Select "Chennai" from destination city
    And Select "Goa" from departure city
    And Select "Pune" from Return
    And Open calender and select the depart day "27"
    And Click on the search