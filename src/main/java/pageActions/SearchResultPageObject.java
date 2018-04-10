/*
 * Created By: Anjali Mutha
 * Description: This is the page object for Search Result page for Buying property in realtor.com website
 * This page contains the webelements on Search Result page of Realtor.com
 * Creation Date: 04/09/2018
 * Modified Date: 04/09/2018
*/

package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPageObject {
	//Driver for page object java file
	WebDriver driver;
	
	//Created Constructor
	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page object for Home Count
	@FindBy(how=How.XPATH, using="//div[contains(@class, '-sort')]/span[contains(text(),' Homes')]")
	public WebElement homeCount;
	
	//Page object for Sort Results
	@FindBy(how=How.XPATH, using="//select[@id='srp-sortby']")
	public WebElement selectByOptions;
	
	
	
	
}
