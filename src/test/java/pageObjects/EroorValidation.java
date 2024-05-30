package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EroorValidation extends BasePage {
	public EroorValidation(WebDriver driver){
		super(driver);
		
	}
	@FindBy(xpath = "//h1[@class='pageType']")
	   WebElement title;
	 @FindBy(id="opp11_ileinner")
	   WebElement ClosedWon;
	
    public boolean Validate_Error() {
     	 try {
     		 return(title.isDisplayed());
     	 }catch(Exception e) {
     		return false;
     	}
		
      
      
      
 }
     
   	   
        public String getErrorMessage() {
   	 try {
   		 return(ClosedWon.getText());
   	 }catch(Exception e) {
   	     return(e.getMessage());
   	}
   	   
      }

}
