package pagerepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DaviesPageObjects {

	private WebDriver driver = null;
	By twitter_icon = By.xpath("//a[@href='https://twitter.com/Davies_Group']");
	By linkedin_icon = By.xpath("//a[@href='https://www.linkedin.com/company/daviesgroup/']");
	By solutionsLink = By.linkText("Solutions");
	By twitterSearchTextbox = By.xpath("//input[@data-testid='SearchBox_Search_Input']");
	By solutionsViewAll = By.xpath("//a[@href='/case-study']");
	By solutionsCaseStudyLoadMore = By.xpath("//button[@class='case-archive__load-more cta-button learn-more']");
	By solutionsCaseStudySearchBar = By.xpath("//span[@id='select2--container']");
	By solutionsCaseStudySearchTextbox = By.xpath("//input[@role='searchbox']");
	By solutionsCaseStudySearchResult = By
			.xpath("//div[@class='case-single-desc__flex--full no-testimonial-case']/p[2]");
	By aboutLink = By.linkText("About");
	By locationsLink = By.linkText("Locations");
	By ukIrelandLink = By
			.xpath("//button[@class='banner__group-button banner__group-button--location text-semibold red']");
	By stokeOnTrentLocationLink = By.xpath("//div[@id='marker0_11']");
	By stokeOnTrentLocationAddressLink = By.xpath("//li[@id='desc0_11']/p");

	private String parentPageURL = "https://davies-group.com/";
	private String parentPageTitle = "Home - Davies";
	private String twitterPageURL = "https://twitter.com/Davies_Group";
	private String twitterPageTitle = "Davies Group (@Davies_Group) / Twitter";
	
	private String solutionsPageURL = "https://davies-group.com/solutions/";
	private String solutionCaseStudySearchText = "Fire investigation";
	private String fireInvestigationURL = "https://davies-group.com/case-study/fire-investigation/";
	private String solutionsCaseStudyURL = "https://davies-group.com/case-study/";
	private String locationsPageURL = "https://davies-group.com/location/";
	private String linkedinURL = "https://www.linkedin.com/";
	private String linkedinTitle = "LinkedIn";

	public DaviesPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickTwitterIcon() {
		
		try {
			System.out.println("Parent page URL = " + driver.getCurrentUrl());
			System.out.println("Parent page title = " + driver.getTitle());
			assertEquals(driver.getTitle(), parentPageTitle);
			assertEquals(driver.getCurrentUrl(), parentPageURL);

			// Store the ID of the original window
			String originalWindow = driver.getWindowHandle();
			// System.out.println("Original window = "+ driver.getWindowHandle());

			// Check we don't have other windows open already
			assert driver.getWindowHandles().size() == 1;
			// System.out.println("Window size = "+ driver.getWindowHandles().size());

			// https://twitter.com/Davies_Group
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement twitterElement;
			twitterElement = wait.until(ExpectedConditions.elementToBeClickable(twitter_icon));

			Actions action = new Actions(driver);
			action.moveToElement(twitterElement).build().perform();
			twitterElement.click();
			
			// System.out.println("Window size = "+ driver.getWindowHandles().size());

			// Loop through until we find a new window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!originalWindow.equalsIgnoreCase(windowHandle)) {
					driver.switchTo().window(windowHandle);
					wait.until(ExpectedConditions.titleContains(twitterPageTitle));
					System.out.println("---------------------------------------------------");
					System.out.println("Child page title = " + driver.getTitle());
					System.out.println("Child page URL = " + driver.getCurrentUrl());
					assertEquals(driver.getCurrentUrl(), twitterPageURL);
					assertEquals(driver.getTitle(), twitterPageTitle);
					
					System.out.println("---------------------------------------------------");
					driver.close();
					break;
				}
			}

			driver.switchTo().window(originalWindow);
			// System.out.println("Window size = "+ driver.getWindowHandles().size());

			System.out.println("Parent page URL = " + driver.getCurrentUrl());
			System.out.println("Parent page title = " + driver.getTitle());
			assertEquals(driver.getTitle(), parentPageTitle);
			assertEquals(driver.getCurrentUrl(), parentPageURL);

			System.out.println("---------------------------------------------------");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickLinkedinIcon() {
		

		try {
			System.out.println("Parent page URL = " + driver.getCurrentUrl());
			System.out.println("Parent page title = " + driver.getTitle());
			assertEquals(driver.getTitle(), parentPageTitle);
			assertEquals(driver.getCurrentUrl(), parentPageURL);

			// Store the ID of the original window
			String originalWindow = driver.getWindowHandle();
			// System.out.println("Original window = "+ driver.getWindowHandle());

			// Check we don't have other windows open already
			assert driver.getWindowHandles().size() == 1;
			// System.out.println("Window size = "+ driver.getWindowHandles().size());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement linkedInElement;
			linkedInElement = wait.until(ExpectedConditions.elementToBeClickable(linkedin_icon));

			Actions action = new Actions(driver);
			action.moveToElement(linkedInElement).build().perform();
			linkedInElement.click();

			// System.out.println("Window size = "+ driver.getWindowHandles().size());

			// Loop through until we find a new window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!originalWindow.equalsIgnoreCase(windowHandle)) {
					driver.switchTo().window(windowHandle);
					wait.until(ExpectedConditions.titleContains(linkedinTitle));
					System.out.println("---------------------------------------------------");
					System.out.println("Child page title = " + driver.getTitle());
					System.out.println("Child page URL = "+ driver.getCurrentUrl());

					String lUrl = driver.getCurrentUrl();
					assertTrue(lUrl.contains(linkedinURL));

					String lTitle = driver.getTitle();
					assertTrue(lTitle.contains(linkedinTitle));
					System.out.println("---------------------------------------------------");
					driver.close();
					break;
				}
			}

			driver.switchTo().window(originalWindow);
			// System.out.println("Window size = "+ driver.getWindowHandles().size());

			System.out.println("Parent page URL = " + driver.getCurrentUrl());
			System.out.println("Parent page title = " + driver.getTitle());
			assertEquals(driver.getTitle(), parentPageTitle);
			assertEquals(driver.getCurrentUrl(), parentPageURL);

			System.out.println("---------------------------------------------------");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickSolutionsLink() {
		try {

			WebElement solutionsLinkElement;
			WebDriverWait wait = new WebDriverWait(driver, 20);
			solutionsLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(solutionsLink));
			solutionsLinkElement.click();

			assertEquals(driver.getCurrentUrl(), solutionsPageURL);

			driver.findElement(solutionsViewAll).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			assertEquals(driver.getCurrentUrl(), solutionsCaseStudyURL);

			WebElement loadMoreElement;
			loadMoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(solutionsCaseStudyLoadMore));

			js.executeScript("javascript:window.scrollBy(673, 2770);");
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(loadMoreElement).build().perform();
			loadMoreElement.click();

			js.executeScript("javascript:window.scrollBy(0, 0);");
			Thread.sleep(1000);
			WebElement searchBarElement = driver.findElement(solutionsCaseStudySearchBar);
			searchBarElement.click();
			WebElement searchTextbox = driver.findElement(solutionsCaseStudySearchTextbox);
			searchTextbox.sendKeys(solutionCaseStudySearchText);
			searchTextbox.sendKeys(Keys.RETURN);
			System.out.println(solutionCaseStudySearchText);
			Thread.sleep(1000);
			
			js.executeScript("javascript:window.scrollBy(673, 800);");
			Thread.sleep(1000);
			WebElement resultDisplay = driver.findElement(solutionsCaseStudySearchResult);
			System.out.println("Result = " + resultDisplay.getText());

			assertEquals(driver.getCurrentUrl(), fireInvestigationURL);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------------------------------");

	}

	public void clickLocationLink() {

		try {

			WebElement aboutLinkElement = driver.findElement(aboutLink);
			Actions action = new Actions(driver);
			action.moveToElement(aboutLinkElement).build().perform();

			driver.findElement(locationsLink).click();
			assertEquals(driver.getCurrentUrl(), locationsPageURL);

			driver.findElement(ukIrelandLink).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(673, 1000);");
			Thread.sleep(500);
			
			driver.findElement(stokeOnTrentLocationLink).click();
			Thread.sleep(500);
			
			System.out.println("Stoke on Trent");
			System.out.println(driver.findElement(stokeOnTrentLocationAddressLink).getText());

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------------------------------");
	}
}
