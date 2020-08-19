Feature: Validate UK Visa Requirement for Japan member for Tourism purpose

Scenario: Check for UK Visa requirement for Japan member for Tourism purpose
    Given User provides nationality as "Japan"
    And User clicks on Next Step button
    When User selects reason as Tourism
    And User clicks on Next Step button
    Then User gets the message as "You won’t need a visa to come to the UK"
    Then Close the browser
    
    