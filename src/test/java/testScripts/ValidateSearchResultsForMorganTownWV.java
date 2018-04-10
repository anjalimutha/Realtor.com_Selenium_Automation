/*
 * Created By: Anjali Mutha
 * Description: This is the main test script for validation of realtor.com website
 * Creation Date: 04/09/2018
 * Modified Date: 04/09/2018
*/

package testScripts;
import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.General;
import constants.Locations;
import constants.PageTitles;
import pageActions.SearchResultPageObject;
import pageActions.HomePageObject;
import pageActions.ViewDetailsPageObject;
import testBase.Utils;

public class ValidateSearchResultsForMorganTownWV extends Utils{

	WebDriver driver;
	
	@Parameters({"browser", "URL"})
	@BeforeTest
	public void invoke(String browser, String URL) {
		//For Chrome browser
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		
		//Validation #1
		driver = invokeBrowser(browser, URL);
		driver.manage().window().maximize();
		System.out.println("-----------SCENARIO 1 PASSED----------------------------------");
		System.out.println("-----------Successfully navigated to realtor.com using "+browser+" browser--------------");
		
		}
		//For Firefox browser
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			
			//Validation #1
			driver = invokeBrowser(browser, "https://www.realtor.com");
			driver.manage().window().maximize();
			System.out.println("-----------SCENARIO 1 PASSED----------------------------------");
			System.out.println("-----------Successfully navigated to realtor.com using "+browser+" browser--------------");
			
			}
		//For Edge browser
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
			
			//Validation #1
			driver = invokeBrowser(browser, "https://www.realtor.com");
			driver.manage().window().maximize();
			System.out.println("-----------SCENARIO 1 PASSED----------------------------------");
			System.out.println("-----------Successfully navigated to realtor.com using "+browser+" browser--------------");
			
			}
	}
	
	//method to close session
		@AfterTest
		public void cleanUpBrowser() {
			 if (driver != null) {
			        driver.quit();
			    }
		}
		
		
	@Test
	public void TC01_Validate_Search_Result() throws Exception{
		
		//Creating objects to access page objects
		HomePageObject home = PageFactory.initElements(driver, HomePageObject.class);
		SearchResultPageObject search = PageFactory.initElements(driver, SearchResultPageObject.class);
		ViewDetailsPageObject viewDetails = PageFactory.initElements(driver, ViewDetailsPageObject.class);
		
		//Extracting page objects
		WebElement logo = home.logo;
		WebElement buyButton = home.buy;
		WebElement rentButton = home.rent;
		WebElement justSoldButton = home.justSold;
		WebElement homeEstimateButton = home.homeEstimate;
		WebElement searchBox = home.searchBox;
		WebElement homeCount = search.homeCount;
		WebElement selectByOptions = search.selectByOptions;
		WebElement priceOnSearchResult = viewDetails.priceOnSearchResult;
		
		
		//wait for home page to load
		waitForPageTitle(driver, PageTitles.HOME_PAGE_TITLE);
		
		//verify if realtor.com logo is displayed
		isElementDisplayed(driver, logo);
		
		//verify if buy button is displayed
		isElementDisplayed(driver, buyButton);
		
		//verify if rent button is displayed
		isElementDisplayed(driver, rentButton);
		
		//verify if just sold button 
		isElementDisplayed(driver, justSoldButton);
		
		//verify if home estimate button is displayed
		isElementDisplayed(driver, homeEstimateButton);
		
		//Clear text box
		clearTextBox(driver, searchBox);
		
		//Search for MorganTown WV and hit enter through keyboard [Validation #2 and #3]
		enterInTextBoxAndHitEnter(driver, searchBox, Locations.MORGANTOWN_WV);
		System.out.println("-----------SCENARIO 2 PASSED---------------------------------");
		System.out.println("-----------Entered MorganTown, WV is nearch box--------------");
		
		System.out.println("-----------SCENARIO 3 PASSED-----------------------");
		System.out.println("-----------Successfully pressed Enter--------------");

		//Wait for title for the search result of MorganTown to appear
		waitForPageTitle(driver, PageTitles.MORGANTOWN_BUY_TITLE);
		
		//Wait until home count is visible
		waitUntilElementVisible(driver, homeCount, General.TWENTY_SECONDS);
		
		//Verify if option selected for sort is sort by relevance
		selectOptionFromDropDown(driver, selectByOptions, General.SORT_BY_RELEANT_LISTING);
		
		//Verify if home count is greater than 0 [Validation #4]
		validateHomeCount(driver, homeCount);
		System.out.println("-----------SCENARIO 4 PASSED--------------------------------------------");
		System.out.println("-----------Validation of number of homes(>0) is successful--------------");

		//Capture price of nth result from all displayed results
		String price = capturePriceForNthResult(driver, General.NUMBER_TWO);
		
		//click on nth address from all results [Validation #5]
		clickOnNthAddress(driver, General.NUMBER_TWO);
		System.out.println("-----------SCENARIO 5 PASSED------------------------------------");
		System.out.println("-----------Successfully clicked on "+General.NUMBER_TWO+"nd address--------------");
	
		
		//Verify if price captured for 2nd result is same in the property listed [Validation #6]
		validatePriceOnSearchResultPage(driver, priceOnSearchResult, price);
		System.out.println("-----------SCENARIO 6 PASSED-------------------");
		System.out.println("-----------Price match successful--------------");
		
	}
	
	//Method to take screenshot if failed
	@AfterMethod
	 public void TearDown(ITestResult result) throws IOException{
	  
	  if (result.getStatus() == ITestResult.FAILURE ){
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File srcFile = ts.getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
	  }
	 }
}
