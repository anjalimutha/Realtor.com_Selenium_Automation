/*
 * Created By: Anjali Mutha
 * Description: This is the page object for home page of realtor.com website
 * This page contains the webelements on Home page of Realtor.com
 * Creation Date: 04/09/2018
 * Modified Date: 04/09/2018
*/

package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageObject {
	//driver for page object java file
	WebDriver driver;
	
	//Created constructor
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page object for realtor logo
	@FindBy(how=How.ID, using="header-rdc-logo")
	public WebElement logo;
	
	//Page object for buy tab
	@FindBy(how=How.XPATH, using="//label[@for='for_sale'][contains(text(),'Buy')]")
	public WebElement buy;
	
	//Page object for Rent tab
	@FindBy(how=How.XPATH, using="//label[@for='for_rent'][contains(text(),'Rent')]")
	public WebElement rent;

	//Page object for Just Sold tab
	@FindBy(how=How.XPATH, using="//label[@for='recently_sold'][contains(text(),'Just Sold')]")
	public WebElement justSold;
	
	//Page object for Home Estimate tab
	@FindBy(how=How.XPATH, using="//label[@for='property_records'][contains(text(),'Home Estimate')]")
	public WebElement homeEstimate;
	
	//Page object for Search Box 
	@FindBy(how=How.XPATH, using="//input[@name='q'][@id='searchBox']")
	public WebElement searchBox;
	
	//Page object for Search Button
	@FindBy(how=How.XPATH, using="//i[@class='ra ra-search']")
	public WebElement searchButton;
	
}
