Feature: Check PostCode service API response and validate the response content

Scenario: Check PostCode service API response and validate the response content
    Given User has valid base URI
    When User makes a get request to postcode service
    Then User receive response status code as 200
    Then Validate the response content
 
   