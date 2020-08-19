Feature: Validate UK Visa Requirement for Japan member for Study purpose
 
 
  Scenario: Check for UK Visa requirement for Japan member for Study purpose more than 6 months
    Given User provides nationality as "Japan"
    And User clicks on Next Step button
    When User selects reason as Study
    And User clicks on Next Step button
    And User states that they intend to stay more than six months
    And User clicks on Next Step button
    Then User gets the message as "You’ll need a visa to study in the UK"
    Then Close the browser
    
    
    
  