package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public  LoginPage(WebDriver driver) {
	super(driver);
	
	}
	@FindBy(id="username")
	private WebElement Username;
	
	@FindBy(id="password")
	private WebElement Password;
	
	
	@FindBy(id="Login")
	private WebElement Loginbutton;
	
	@FindBy(id="userNavButton")
	private WebElement salesForceAccountName;
	@FindBy(xpath="//*[@id=\"88:232;a\"]/span[1]/div/span")
	private WebElement accountpage;
	@FindBy(xpath="//*[@id='content_119:1654;a']/div/div[2]/div/a[2])")
	private WebElement logout;
	
	
	
	public void setUsername(String name) {
		Username.sendKeys(name);
	}
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	public void clickLogin() {
		Loginbutton.click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getText() {
		String MainUsername= salesForceAccountName.getText();
		return MainUsername;
	}
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (salesForceAccountName.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	public void logout() {
		accountpage.click();
		logout.click();
		
		
	}

	
	

}
