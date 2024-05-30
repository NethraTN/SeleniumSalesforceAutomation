package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OpportunityCreationTab extends BasePage {
	 public OpportunityCreationTab(WebDriver driver) {
		 super(driver);
	 }
	 
	 	@FindBy(name="newOpp")
	 	private WebElement NewOpportunityButton;
	 	@FindBy(id="opp3")
	 	private WebElement OpportunityName;
	 	
	 	@FindBy(id="opp11")
	 	private WebElement Stage;
	 	@FindBy(id="opp9")
	 	private WebElement closeDate;
	 	@FindBy(xpath="//*[@id=\"topButtonRow\"]/input[1]")
	 	private WebElement savebutton;
	 	
	 	@FindBy(xpath="//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h2")
	 	private WebElement opportunitynameTab;
	 	@FindBy(name="edit")
	 	private WebElement opportunityEdit;
	 	
	 	public String verifyOpportunityCreated() {
	 		return opportunitynameTab.getText();
	 	}
	 	public void clickNewOpportunityButton() {
	 		NewOpportunityButton.click();
	 	}
	 	public void setOpportunityName(String name) {
	 		OpportunityName.sendKeys(name);
	 	}
	 	public void setStage(String stageText) {
	 		 Select stageSelect = new Select(Stage);
	         stageSelect.selectByValue(stageText);
	 	}
	 	public void setDateofClosing(String date) {
	 		closeDate.sendKeys(date);
	 	}
	 	public void clickSaveButton() {
	 		savebutton.click();
	 	}
	 
	 	public void clickEdit() {
	 		opportunityEdit.click();
	 	}
	 
}

