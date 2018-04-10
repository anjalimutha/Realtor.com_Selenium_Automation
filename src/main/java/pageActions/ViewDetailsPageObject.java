/*
 * Created By: Anjali Mutha
 * Description: This is the page object for View Details of search results page for Buying property in realtor.com website
 * This page contains the webelements on View Details page of Realtor.com
 * Creation Date: 04/09/2018
 * Modified Date: 04/09/2018
*/
package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ViewDetailsPageObject {
	//Driver for page object java file
	WebDriver driver;
	
	//Created Constructor
	public ViewDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page object for Price on selected property
	@FindBy(how=How.XPATH, using = "//span[@itemprop='price']")
	public WebElement priceOnSearchResult;
	
}
