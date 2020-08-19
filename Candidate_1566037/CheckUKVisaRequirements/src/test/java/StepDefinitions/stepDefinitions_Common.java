package StepDefinitions;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions_Common {

	public WebDriver driver;
	public String CountryName;
	public String ReasonTravel;
	
	//User provides nationality
	@Given("User provides nationality as {string}")
	public void user_provides_nationality_as(String countryName) {
		try {
			CountryName = countryName;
			System.setProperty("webdriver.gecko.driver",
					"/WorkingFolder/CheckUKVisaRequirements/DriverFiles/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.gov.uk/check-uk-visa/y");

			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			WebElement countryNameDropdown = driver.findElement(By.id("response"));
			Select selectCountry = new Select(countryNameDropdown);
			selectCountry.selectByVisibleText(countryName);
			
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[1]/button")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//User selects option Study for travel
	@When("User selects reason as Study")
	public void user_selects_reason_as_study() {
		try {
			ReasonTravel="Study";
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.findElement(By.id("response-2")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	//Duration of the Study is longer than 6 months
	@And("User states that they intend to stay more than six months")
	public void user_states_that_they_intend_to_stay_more_than_six_months() {
	    try {
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.findElement(By.id("response-1")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//User clicks on Next Step button
	@And("User clicks on Next Step button")
	public void user_clicks_on_next_step_button() {
		try {
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"current-question\"]/button")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//User gets the message whether Visa required for travel to UK or not
	@Then("User gets the message as {string}")
	public void user_gets_the_message_as(String expectedMessage) {
		
	    try {
			String actualMessage = driver.findElement(By.xpath("//*[@id=\"result-info\"]/div[2]/h2")).getText();
			assertEquals(expectedMessage, actualMessage);
			System.out.println("-----------------------------------------------");
			System.out.println("Country Name: "+ CountryName);
			System.out.println("Reason for travel to UK: "+ ReasonTravel);
			System.out.println("Expected message: "+ expectedMessage);
			System.out.println("Actual message: "+ actualMessage);
			Assert.assertEquals(expectedMessage, actualMessage);
			System.out.println("-----------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//User selects option Tourism for travel
	@When("User selects reason as Tourism")
	public void user_selects_reason_tourism() {
		try {
			ReasonTravel="Tourism";
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.findElement(By.id("response-0")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//User selects option yes for travelling with family/partner
	@And("User clicks on Yes option for Travelling with family")
	public void user_clicks_on_yes_option_for_travelling_with_family_and_submits_the_form() {
		try {
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.findElement(By.id("response-0")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//User selects option yes for having Article 10/20 card while travelling
	@When("User clicks on Yes option for having Article Ten or Twenty card")
	public void user_clicks_on_yes_option_for_having_article_ten_or_twenty_card_and_submits_the_form() {
		try {
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.findElement(By.id("response-0")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//End the process by closing the web browser
	@Then("Close the browser")
	public void close_the_browser() {
		try {
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			driver.close();
			System.out.println("-----------------------------------------------");
			System.out.println("************Closing the Web Browser************");
			System.out.println("-----------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
