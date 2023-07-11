Feature: LetCarWork

  @validDataCar
  Scenario:
    Given User launches Chrome Browser
    When User opens ilCarro HomePage
    And User clicks on Log in link
    And User enters valid data
    And User clicks on Yalla button
    And User clicks on Let the car work link
    And User enters valid data car
    And User clicks on Submit button
    Then User verifies positive message
    And User quites browser