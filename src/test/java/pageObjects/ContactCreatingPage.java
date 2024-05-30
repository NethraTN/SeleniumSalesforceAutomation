package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactCreatingPage extends BasePage {
	public  ContactCreatingPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="newContact")
	private WebElement contactButton;
	
	 @FindBy(name="name_lastcon2")
	 private WebElement contactName;
	 
	 @FindBy(xpath="//*[@id=\"topButtonRow\"]/input[1]")
	 private WebElement saveContact;
	 
	 @FindBy(id="errorDiv_ep")
	 private WebElement ErrormsgTab;
	 
	public void clickNewcontactButton() {
		contactButton.click();
	}
	public void setContactname(String contactname) {
		contactName.sendKeys(contactname);
	}
	public void clickSaveButton() {
		saveContact.click();
	}
	public boolean contacterrorTab() {
		boolean iserrormsgForcontactdisplayed=ErrormsgTab.isDisplayed();
		return iserrormsgForcontactdisplayed;
	}

}
