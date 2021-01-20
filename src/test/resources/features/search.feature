Feature:Verifying the search
  Scenario: Homepage verification
    Given user is in landing page
    Then Verify that "Browse By Make" is present
    Then Verify that "Browse By Style" is present
    Then Verify that "Browse By Search" is present
    And Verify that Search button is present
    Then Verify that "Any Make" and "Any Model" is present


