package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductTab extends BasePage {
	public  AddProductTab(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="addProd")
	private WebElement AddProductButton;
	
	@FindBy(xpath="//*[@id=\"01uIS000002eb1o\"]")
	private WebElement Product1;
	@FindBy(xpath="//*[@id='01uIS000002eb1h']")
	private WebElement product2;
	@FindBy(xpath="//*[@id=\'dispatch\']/div[1]/input[1]")
	private WebElement saveProductbutton;
	@FindBy(xpath="//*[@id=\'Quantity01uIS000002eb1o\']")
	private WebElement quantity1;
	@FindBy(xpath="//*[@id=\'Quantity01uIS000002eb1h\']")
	private WebElement quantity2;
	@FindBy(xpath="//*[@id=\'editPage\']/table/tbody/tr[1]/td/input[1]")
	private WebElement QuantitysaveButton;
	@FindBy (xpath="//*[@id=\"001IS000004s8yG_RelatedOpportunityList_body\"]/table/tbody/tr[2]/th/a")
	 private WebElement opportunitynameclick;
	
	public void clickopportunityname() {
	 	opportunitynameclick.click();
	 	}
	public void clickAddProductButton() { 
		AddProductButton.click();
	}
	public void selectProduct1() {
		Product1.click();
		product2.click();
	}
	public void clicksaveProduct() {
		saveProductbutton.click();
	}
	public void addQuantity(String q1,String q2) {
		quantity1.sendKeys(q1);
		quantity2.sendKeys(q2);	
	}
	public void clickQuantitySaveButton() {
		 QuantitysaveButton.click();
			
	}
	

}
