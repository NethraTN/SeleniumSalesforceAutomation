package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTask extends BasePage {
	public AddTask(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="task")
	private WebElement NewTaskbutton;
	@FindBy(name="tsk5")
	private WebElement SubjectTab;
	@FindBy(name="save")
	private WebElement saveTask;
	@FindBy(id="reminder_select_check")
	private WebElement reminderclose;
	
	public void clickNewTaskbutton() {
		NewTaskbutton.click();
	}
	public void SetSubjectValue(String s) {
		SubjectTab.sendKeys(s);
	}
	public void clickSaveTask() {
		saveTask.click();
	}
	public void setreminderoff() {
		reminderclose.click();
	}
	

}
