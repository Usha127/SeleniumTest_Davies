package seleniumtests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagerepository.DaviesPageObjects;

public class MyTest {

	WebDriver driver = null;

	@BeforeMethod
	public void setUp() {
		//System.out.println("Inside method - setUp");
		System.setProperty("webdriver.gecko.driver", "/WorkingFolder/Selenium_Test/DriverFiles/geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://davies-group.com/");
		
	}

	@Test(priority = 0)
	public void check_twitterLink() {
		System.out.println("---------------------------------------------------");
		System.out.println("---------------Twitter link test-------------------");
		System.out.println("---------------------------------------------------");

		DaviesPageObjects obj = new DaviesPageObjects(driver);
		obj.clickTwitterIcon();

	}

	@Test(priority = 1)
	public void check_linkedinLink() {

		System.out.println("---------------------------------------------------");
		System.out.println("---------------LinkedIn link test------------------");
		System.out.println("---------------------------------------------------");

		DaviesPageObjects obj = new DaviesPageObjects(driver);
		obj.clickLinkedinIcon();

	}

	@Test(priority = 2)
	public void check_SolutionsLink() {
		System.out.println("---------------------------------------------------");
		System.out.println("---------------Solutions link test-----------------");
		System.out.println("---------------------------------------------------");

		DaviesPageObjects obj = new DaviesPageObjects(driver);
		obj.clickSolutionsLink();

	}

	@Test(priority = 3)
	public void check_LocationLink() {
		System.out.println("---------------------------------------------------");
		System.out.println("---------------Location link test------------------");
		System.out.println("---------------------------------------------------");

		DaviesPageObjects obj = new DaviesPageObjects(driver);
		obj.clickLocationLink();

	}

	@AfterMethod
	public void windup() {
		driver.quit();
	}

}
