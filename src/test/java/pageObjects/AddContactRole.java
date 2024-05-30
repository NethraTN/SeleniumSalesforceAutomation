package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddContactRole extends BasePage{
	
	public AddContactRole(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="newRole")
	private WebElement newRolebutton;
	 @FindBy(id="primary0")
	 private WebElement primarybutton;
	 @FindBy(id="role0")
	 private WebElement roleDropDown;
	 @FindBy(name="save")
	 private WebElement saveButton;
	 
	 public void clickNewRole() {
		 newRolebutton.click();
	 }
	 
	 public void clickPrimaryContactButton() {
		 primarybutton.click();
	 }
	 public void selectRole(String s) {
		 Select drpRole=new Select(roleDropDown);
		 drpRole.selectByValue(s);
	 }
	 public void clickSaveButton() {
		 saveButton.click();
	 }
}
