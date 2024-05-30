package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddEvent extends BasePage{
	String Main_window;
	public static String Mainwindowpage;
	public AddEvent(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(name="event")
	 private WebElement neweventbutton;
	@FindBy(xpath="//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img")
	 private WebElement subjectlookupbutton;
	//@FindBy(id="StartDateTime")
	// private WebElement StartDate;
	
	
	
	@FindBy(id="StartDateTime")
	WebElement Startdate;
	
	@FindBy(id="calMonthPicker")
	WebElement month;
	
	@FindBy(id="calYearPicker")
	WebElement enddate;
	
	@FindBy(xpath="//*[@id=\"calRow1\"]/td[3]")
	WebElement s_date;
	
	
	
	@FindBy(id="EndDateTime")
	 private WebElement EndDate;
	
	@FindBy(id="calMonthPicker")
	WebElement E_month;
	
	@FindBy(id="calYearPicker")
	WebElement e_year;
	
	@FindBy(xpath="//*[@id=\"calRow2\"]/td[5]")
	WebElement E_date;
	
	
	@FindBy(id="reminder_select_check")
	 private WebElement reminder;
	@FindBy(xpath="//*[@id=\"topButtonRow\"]/input[1]")
	private WebElement saveEventbutton;
	@FindBy(xpath="/html/body/div[2]/ul/li[1]/a")
	private WebElement Choose1;
	
	@FindBy(xpath="//*[@id=\"RelatedActivityAttachmentList\"]/div[1]/div/div[1]/table/tbody/tr/td[2]/input")
	private WebElement click_attach_file;
	
	@FindBy(id="file")
	private WebElement choosefile;
	
	@FindBy(id="Attach")
	private WebElement Attach;
	
	@FindBy(xpath="//*[@id=\"editPage_1\"]/table/tbody/tr[3]/td[2]/input")
	private WebElement done;
	
	
	
	public void clicknewEvent() {
		neweventbutton.click();
		
	}
	
	public void setSubjectByclickinglookup() {
		Main_window=driver.getWindowHandle();
		subjectlookupbutton.click();
		Set<String> AllWindowHandles=driver.getWindowHandles();
		for(String LookupWindow:AllWindowHandles) {
			if(! LookupWindow.equals(Main_window)){
	    		driver.switchTo().window(LookupWindow);
	    		System.out.println("Lookup page Title"+driver.getTitle());
	          }
		}
		
    	
    	
    	Choose1.click();
    	try {
        	driver.switchTo().defaultContent();
        	driver.close();
    	}
    	catch(Exception e) {
    		driver.switchTo().window(Main_window);
    	}
		
		
		
	}
	public void setStartDate() {
		
		
		Startdate.click();
		month.click();
		Select s=new Select(month);
		s.selectByVisibleText("April");
		enddate.click();
		Select s1=new Select(enddate);
		s1.selectByVisibleText("2025");
		s_date.click();
		
		
		
		
		
		
		EndDate.click();
E_month.click();
Select s2=new Select(E_month);
s2.selectByVisibleText("April");
e_year.click();

Select s3=new Select(e_year);
s3.selectByVisibleText("2025");
E_date.click();


}
	/*public void setEndDate(String s) {
		
		EndDate.sendKeys(s);
	}
	public void clickReminderOff() {
		reminder.click();
	}
	*/
	
   public void attach_file() throws Exception  {
	
	
	Mainwindowpage=driver.getWindowHandle();
	click_attach_file.click();
	Set<String> AllWindowHandles=driver.getWindowHandles();
    
	for(String LookupWindow:AllWindowHandles) {
		
		if(! LookupWindow.equals(Mainwindowpage)) {
			
		driver.switchTo().window(LookupWindow);
		System.out.println("Lookup page Title"+driver.getTitle());
      }
	}
	choosefile.sendKeys("C:\\Users\\2321758\\eclipse-workspace\\Main2Project\\testData\\Screenshot (2).png");
	
	Attach.click();
   Thread.sleep(3000);
   done.click();
   
   try {
	   driver.switchTo().window(Mainwindowpage);
   }
   catch(Exception e) {

	   driver.switchTo().window(Mainwindowpage);
	   
	
}
   
   saveEventbutton.click();
   }
	


}

