
Feature: Lauch Selenium Test page
 
 	@SmokeTest @RegressionTest @End2End
  Scenario Outline: Lauch Selenium Test page and verify details
    Given User is on the web page
    Then Verify the page title as "Selenium Test"
    When User click on the View Details Button <Id>
   	Then Verify the Customer "<Name>" and "<Email>" and "<Phone>" Details on the page
   	Then Close the browser
   	
   Examples:
   	|	Id	|	Name	|	Email	|	Phone	|
   	|	1	|	John Smith	|	jsmith@test.com	|	0208092029	|	
		|	2	|	Jeff Bridges	|	abcd@test.com	|	0161 225 7632	|
   	|	3	|	Steve Jones	|	steven.jones@test.com	|	01403 215100	|
   	
   	
    

  
