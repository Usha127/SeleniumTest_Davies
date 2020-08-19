Feature: Validate UK Visa Requirement for Russia member for Tourism purpose

Scenario: Check for UK Visa requirement for Russia member for Tourism purpose
    Given User provides nationality as "Russia"
    And User clicks on Next Step button
    When User selects reason as Tourism
    And User clicks on Next Step button
    And User clicks on Yes option for Travelling with family 
    And User clicks on Next Step button
    And User clicks on Yes option for having Article Ten or Twenty card 
    And User clicks on Next Step button
    Then User gets the message as "You do not need a visa to come to the UK"
    Then Close the browser