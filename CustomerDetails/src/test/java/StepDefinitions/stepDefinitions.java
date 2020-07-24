package StepDefinitions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

import static org.junit.Assert.*;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {

	public WebDriver driver;
	public int buttonId;

	
	@Before
	public void startUp() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\WorkingFolder\\CustomerDetails\\DriverFiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://9a2cdb3e.azurewebsites.net/customerlist");
		Thread.sleep(1000);
	}
	
	@Given("User is on the web page")
	public void user_is_on_the_web_page() {
		System.out.println("User is on home page");
	}
	
	
	@Then("Verify the page title as {string}")
	public void verify_the_page_title_as(String expectedPageTitle) {
		String actualPageTitle = driver.getTitle();
		System.out.println("Page Title is = " + actualPageTitle);
		assertEquals(expectedPageTitle, actualPageTitle);
	}

	

	
	
	@When("User click on the View Details Button {int}")
	public void user_click_on_the_view_details_button(Integer btnId) {
		
		buttonId = btnId;
		switch(btnId) {
		case 1: 
			driver.findElement(By.xpath("//button[@data-test='1']")).click();
			break;
		case 2: 
			driver.findElement(By.xpath("//button[@data-test='2']")).click();
			break;
		case 3: 
			driver.findElement(By.xpath("//button[@data-test='3']")).click();
			break;
			 
		default:
			System.out.print("Default first button");
			
			
		}
			
	}
	
	

	@Then("Verify the Customer {string} and {string} and {string} Details on the page")
	public void verify_the_customer_and_and_details_on_the_page(String expectedName, String expectedEmail, String expectedPhone) {
		String titleName; String actualName; String actualEmail; String actualPhone;
		
		 
			//Customer Name in the title
			titleName = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/h3")).getText();
			System.out.println("Pannel Title = "+ titleName);
			assertTrue(titleName.contains(expectedName));
			
			//Customer Name in details section
			actualName = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/p[1]")).getText();
			System.out.println("actualName = "+ actualName);
			System.out.println("expectedName = "+ expectedName);
			assertTrue(actualName.contains(expectedName));
			
			//Customer Email in details section
			actualEmail = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/p[2]")).getText();
			System.out.println("actualEmail = "+ actualEmail);
			System.out.println("expectedEmail = "+ expectedEmail);
			assertTrue(actualEmail.contains(expectedEmail));
						
			//Customer Phone number in details section
			actualPhone = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/p[3]")).getText();
			System.out.println("actualPhone = "+ actualPhone);
			System.out.println("expectedPhone = "+ expectedPhone);
			assertTrue(actualPhone.contains(expectedPhone));
			
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS) ;
	    driver.close();
	}

	
	
	
	

}
