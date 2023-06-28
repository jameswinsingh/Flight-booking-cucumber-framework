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
    And close the browser

  Scenario Outline: Book Flight for multiple users
    Given Launch application
    When Select county name as "<Country>"
    Then User should select "<Country>" as the country name
    When Click on Round Trip radio button
    And Select "<From>" on FROM tab
    And Select "<TO>" on To tab
    And Open calender and select the depart day "<DepartDate>"
    And Open calender and select the return day "<ReturnDate>"
    And select adult passenger count as "<Adult>"
    Then Count of the adult passenger should be "<Adult> Adult"
    When select child passenger count as "<Child>"
    Then Count of the child passenger should be "<Child> Child"
    When select infant passenger count as "<Infant>"
    Then Count of the infant passenger should be "<Infant> Infant"
    When click on done
    Then Check if the drop down is disappeared after clicking Done
    When Select currency as "<Currency>"
    And Click on search
    And close the browser

    Examples:
      | Country  | From     | TO             | DepartDate | ReturnDate | Adult | Child | Infant | Currency |
      | China    | Bagdogra | Vishakhapatnam | 19         | 21         | 1     | 2     | 3      | USD      |
      | American | Amritsar | Dehradun       | 20         | 24         | 3     | 2     | 1      | INR      |
