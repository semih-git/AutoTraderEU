Feature:Verifying the search
  Scenario: Homepage verification
    Given user is in landing page
    Then Verify that "Browse by Make" is present
    Then Verify that "Browse by Style" is present
    Then Verify that "Advance Search" is present
    And Verify that Search button is present
    Then Verify that "Any Make" and "Any Model" is present


