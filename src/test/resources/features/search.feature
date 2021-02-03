@smoke_test_main
Feature: Verifying the search

  Background: Browser testing
    Given user test with "firefox" browser



  @usr234
  Scenario: User checks the Advance search link
    Given User is in Advance Search home page
    Then User enter "30004" in the zip code text box
    Then User select "Certified" check box under "Condition"
    Then User select "Convertible" check box under "Style"
    Then user update Year "2017" to "2020"
    Then user select "BMW" car from Make,Model and Trim section
    Then User clicks Search button
    Then User verifies that he is in result page
    Then User verifies that he sees only "BMW" cars in listing
    Then Display in console, the number of cars listed in result page

