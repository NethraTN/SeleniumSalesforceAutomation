package pageObjects;


	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	public class AccountTab  extends BasePage {
		public  AccountTab(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(xpath="//*[@id=\"Account_Tab\"]/a")
		private WebElement Accounts;
		
		@FindBy(xpath="//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")
		private WebElement Newbutton;
		
		@FindBy(xpath="//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
		private WebElement createdAccount;
		
		
		
		public void clickAccountsTab() {
			Accounts.click();
		}
		public void clickNewbutton() {
			Newbutton.click();
			
		}
		public void clickonCreatedAccount() {
			createdAccount.click();
		}


}

