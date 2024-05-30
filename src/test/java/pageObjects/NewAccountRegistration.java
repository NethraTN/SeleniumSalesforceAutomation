package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountRegistration extends BasePage {
	
	public  NewAccountRegistration(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="acc2")
	private WebElement Account_name;
	
	@FindBy(xpath="//*[@id=\"topButtonRow\"]/input[1]")
	private WebElement SaveButton;
	
	@FindBy(xpath="//*[@id=\"contactHeaderRow\"]/div[2]/h2")
	private WebElement VerifyingAccName;
	
	@FindBy(id="createNewButton")
	private WebElement createnewButton;
	
	@FindBy(xpath="//div[@id='createNewMenu']/a")
	private List<WebElement> dropdownOptions;
	
	
	@FindBy(id="errorDiv_ep")
	private WebElement errorMessageElement;

	
	
	public void setAccountName(String Accname) {
		Account_name.sendKeys(Accname);
	}
	public void clickSaveButton() {
		SaveButton.click();
	}
	public String validateAccountCreation() {
		return VerifyingAccName.getText();
		
	}
	public void clickCreateNewButton() {
		createnewButton.click();
		for (WebElement option : dropdownOptions) {
	        if (option.getText().equals("Account")) {
	            option.click();
	            break;
	        }
	    }
		

	}
	public boolean errorTab() {
		boolean isErrorMessageDisplayed = errorMessageElement.isDisplayed();
		return isErrorMessageDisplayed ;
	}
	

}
