/*
 * Created By: Anjali Mutha
 * Description: This is the main utils java file of realtor.com website
 * This page contains all the functions that can be used for automating the website of Realtor.com
 * Creation Date: 04/09/2018
 * Modified Date: 04/09/2018
*/
package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestException;

import pageActions.SearchResultPageObject;
import pageActions.HomePageObject;
import pageActions.ViewDetailsPageObject;

public class Utils{
	public static WebDriver driver;
	
	HomePageObject home = PageFactory.initElements(driver, HomePageObject.class);
	SearchResultPageObject buy = PageFactory.initElements(driver, SearchResultPageObject.class);
	ViewDetailsPageObject search = PageFactory.initElements(driver, ViewDetailsPageObject.class);
	
	//method to start browser
public WebDriver invokeBrowser(String Browsername, String URL) {
		try {
			if(Browsername.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
			}
			else if (Browsername.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
			}
			else if (Browsername.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				driver.manage().deleteAllCookies();
			}
			
			driver.manage().window().maximize();
			driver.get(URL);
			return driver;
		} catch (Exception e) {
			throw new TestException("Error while opening browser");
		}
		
	}

//method to wait for visibility of title for a page
public void waitForPageTitle(WebDriver driver, String title) {
	try {

		 new WebDriverWait(driver, 50).until(ExpectedConditions.titleIs(title));

	} catch (Exception e) {
		throw new TestException("Error on navigation");
	}
}

//Method to click on any given element
public void clickOnElement(WebDriver driver, WebElement element) {
	try {

		 element.click();

	} catch (Exception e) {
		throw new TestException("Error on clicking");
	}
}

public void clickOnElementAndWait(WebDriver driver, WebElement element, int wait) {
	try {

		 element.click();
		 driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);

	} catch (Exception e) {
		throw new TestException("Error on click and wait");
	}
}

//Method to verify if any given element is displayed
public void isElementDisplayed(WebDriver driver, WebElement element) {
	try {

		 Assert.assertTrue(element.isDisplayed(), element + " is not displayed");

	} catch (Exception e) {
		throw new TestException("Error Element not displayed");
	}
}

//method to clear text box
public void clearTextBox(WebDriver driver, WebElement element) {
	try {
		element.clear();
		
	} catch (Exception e) {
		throw new TestException("Error unable to clear text");
	}
}

//Method to enter a text in any textbox
public void enterInTextBox(WebDriver driver, WebElement element,String text) {
	try {
		
		element.sendKeys(text);

	} catch (Exception e) {
		throw new TestException("Unable to send keys to text box");
	}
}	

//Method to enter text and hit enter for any textbox
public void enterInTextBoxAndHitEnter(WebDriver driver, WebElement element, String text) {
	try {
		element.sendKeys(text);
		element.sendKeys(Keys.ENTER);
		
	} catch (Exception e) {
		throw new TestException("Unable to send keys to text box and hit enter");
	}
}

//Method to wait until any given element is visible
public void waitUntilElementVisible(WebDriver driver, WebElement element, int second) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.visibilityOf(element));

	} catch (Exception e) {
		throw new TestException("Error Element not found after waiting");
	}
}

//Method to select option from dropdown
public void selectOptionFromDropDown(WebDriver driver, WebElement element, String verifytext) {
	try {
		 Select selectedValue = new Select(element);
		 selectedValue.selectByVisibleText(verifytext);
	} catch (Exception e) {
		throw new TestException("Error Text do not match on select dropdown");
	}
}

//Method to validate total number of homes displayed in result
public void validateHomeCount(WebDriver driver, WebElement element) {
	try {
String text = element.getText().toString();
		
		String [] number = text.split(" ");
		int num = Integer.parseInt(number[0]);
		Assert.assertTrue(num>0, "Number of homes is not greater than zero");
		
	} catch (Exception e) {
		throw new TestException("Error on total number of homes");
	}
}

//Method to capture price for nth result
public String capturePriceForNthResult(WebDriver driver,  int n){
	try {
		WebElement element = driver.findElement(By.xpath("(//span[contains(@class, 'data-price')])[" +n+ "]"));
String price = element.getText().toString();
		return price;
	
	} catch (Exception e) {
		throw new TestException("Element not found after waiting");
	}
}

//Method to click on nth address in result 
public void clickOnNthAddress(WebDriver driver,  int n){
	try {
		
		WebElement element = driver.findElement(By.xpath("(//div[@data-label='property-address']/a)[" +n+ "]"));
		element.click();
		
		
		
	} catch (Exception e) {
		throw new TestException("Could not click on nth address");
	}
}

//method to validate price on buy tab and individual property listing tab
public void validatePriceOnSearchResultPage(WebDriver driver, WebElement element, String price){
	try {
		String price1 = element.getText().toString();
		Assert.assertTrue(price.equals(price1), "Price do not match");
		
	} catch (Exception e) {
		throw new TestException("Error price do not match");
	}
	
	
}

	}

