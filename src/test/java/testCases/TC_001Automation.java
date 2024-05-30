package testCases;
import testBases.BaseClass;
import utilities.DataProviders;


import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.AccountTab;
import pageObjects.AddContactRole;
import pageObjects.AddEvent;
import pageObjects.AddProductTab;
import pageObjects.AddTask;

import pageObjects.ContactCreatingPage;
import pageObjects.EroorValidation;
import pageObjects.LoginPage;
import pageObjects.NewAccountRegistration;
import pageObjects.OpportunityCreationTab;





public class TC_001Automation extends BaseClass {
	
	
	
	@Test
	(priority=0,dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void dataDrivenLogin(String email,String password,String result) {
		logger.info("***starting data driven test***");
		LoginPage lpg=new LoginPage(driver);
		
		lpg.setUsername(email);
		logger.info("Entered username");
		lpg.setPassword(password);
	    logger.info("entered pssword");
		lpg.clickLogin();
		logger.info("clicked on login button");
		logger.info("logging in");
		String title=lpg.getPageTitle();
		Assert.assertEquals(result,title,"title doesnt match");
		if(title.equals(result)) {
			Assert.assertTrue(true);
			logger.info("login succesful");
		}
		else {
			Assert.assertTrue(false);
			logger.info("loggin unsuccesful");
		}
	}

	@Test(priority=1)
public void enterDetails() {
	AccountTab acc=new AccountTab(driver);
	acc.clickAccountsTab();
	logger.info("clicked on accounts tab in home page");
	acc.clickNewbutton();
	logger.info("clicked on new button in accounts tab ");
	NewAccountRegistration nr=new NewAccountRegistration(driver);
	nr.setAccountName(p.getProperty("errormessageaccname"));
	logger.info("sending null value");
	nr.clickSaveButton();
	logger.info("clicking on save button");
    boolean isErrorMessageDisplayed = nr.errorTab();
	Assert.assertTrue(isErrorMessageDisplayed, "Error message is not displayed");
	logger.info("Error message is displayed when mandatory field is not displayed");	
}
	@Test(priority=2)
	public void validatingErrorMsg() {
		NewAccountRegistration nr=new NewAccountRegistration(driver);
		nr.setAccountName(p.getProperty("accname"));
		logger.info("account name inserted succefully");
		nr.clickSaveButton();
		logger.info("clicked on save button succesfully");
	}
	@Test(priority=3)
	public void validatingAccountCreation() {
			// to validate account created by the name we given or not.
			NewAccountRegistration nr=new NewAccountRegistration(driver);
			String name=nr.validateAccountCreation();
			Assert.assertEquals(name,p.getProperty("accname"));
			logger.info("Created Account succesufully and validated name. ");
			}

	@Test(priority=4)
	public void errorValidatingWhilecreatingContact() {
		ContactCreatingPage contact=new ContactCreatingPage(driver);
		contact.clickNewcontactButton();
		logger.info("clicked on new contact buttopn to create new contact");
		contact.setContactname(p.getProperty("contactnameforErrorvalidating"));
		logger.info("null value is sent to validate error message is displayed or not while not entering mandatory field");
		contact.clickSaveButton();
		logger.info("clicked on save");
		
		boolean iserrormsgForcontactdisplayed=contact.contacterrorTab();
		Assert.assertTrue(iserrormsgForcontactdisplayed,"Errormessage not displayed");
		logger.info("verifying error message is displayed");
	}
	@Test(priority=5)
	public void creatingNewContact() {
		ContactCreatingPage contact=new ContactCreatingPage(driver);
		contact.setContactname(p.getProperty("contactname"));
		logger.info("mandatory lastname is filled");
		contact.clickSaveButton();
		logger.info("clicked on save");
	}
		
		
	
		@Test(priority=6)
		public void opportunityCreation() {
			OpportunityCreationTab ot=new OpportunityCreationTab(driver);
			ot.clickNewOpportunityButton();
			logger.info("clicked on new opportunity ");
			ot.setOpportunityName(p.getProperty("opportunityname"));
			logger.info("opportunity name is set");
			ot.setDateofClosing(p.getProperty("dateOfclosing"));
			logger.info("date of closing is set");
			ot.setStage(p.getProperty("stage_of_contact"));
			logger.info("stage of contact is set");
			ot.clickSaveButton();
			logger.info("clicked on save button");
			
		}
		@Test(priority=7)
		public void verifyOpportunityCreation() {
			OpportunityCreationTab ot=new OpportunityCreationTab(driver);
			String opname=ot.verifyOpportunityCreated();
			Assert.assertEquals(opname, p.getProperty("opportunityname","opporunity name is not craeted as give"));
			logger.info("opportunity is created succefully and displayed on tab");
		}
		@Test(priority=8)
		public void Addingproduct() {
			
			AddProductTab at=new AddProductTab(driver);
			logger.info("***adding product is started***");
			at.clickAddProductButton();
			logger.info("clicked on account button");
			at.selectProduct1();
			logger.info("product are selected from list");
			at.clicksaveProduct();
			logger.info("Products are saved");
			at.addQuantity(p.getProperty("q1"),p.getProperty("q2"));
			logger.info("quantity for product is choosed");
			at.clickQuantitySaveButton();
			logger.info("products are saved succesfully");
		}
		
		@Test(priority=9)
		
		public void contactRoleAdd() {
			AddContactRole Ac=new AddContactRole(driver);
			Ac.clickNewRole();
			logger.info("Clicked on new role button");
			Ac.clickPrimaryContactButton();
			logger.info("primary check box is choosen");
			Ac.selectRole(p.getProperty("Rolename"));
			logger.info("Role name is chosen from dropdown");
			Ac.clickSaveButton();
			logger.info("saved succesfully");
		}
		@Test (priority=10)
		public void newTask() {
			AddTask at=new AddTask(driver);
			at.clickNewTaskbutton();
			logger.info("new task button task");
			at.SetSubjectValue(p.getProperty("TaskName"));
			logger.info("subject name is set");
			at.setreminderoff();
			logger.info("task reminder off ");
			at.clickSaveTask();
			logger.info("new task is created");
			
		}
		
		@Test(priority=11)
		public void addEvent() throws Exception {
			AddEvent Ae=new AddEvent(driver);
			Ae.clicknewEvent();
			logger.info("click on new event button");
			Ae.setSubjectByclickinglookup();
			logger.info("selected from lookup file");
		
			Ae.setStartDate();
			logger.info("selected from startdate");
			//Ae.setEndDate();
			logger.info("selected from enddate");
			//Ae.clickReminderOff();
			 logger.info("Clicked on reminder off");
//			 Attachfile ad=new Attachfile(driver);
//			ad.clickAttachfilebutton();
//			logger.info("click on attach file");
//			ad.clickchoosefilebutton("Location");
//			logger.info("file is attached");
			 Ae.attach_file();
			 
			  
			
			
			
			
		
		
		}
		
		/*@Test(priority=12) 
		public void attachfile(){
		Attachfile ad=new Attachfile(driver);
		Set<String> AllWindowHandles4=driver.getWindowHandles();
        
    	for(String LookupWindow:AllWindowHandles4) {
    		
    		if(! LookupWindow.equals(P_MainWindowPage7)) {
    			
    		driver.switchTo().window(LookupWindow);
    		System.out.println("Lookup page Title"+driver.getTitle());
          }
    	}
    	Thread.sleep(5000);
		
		
		
		
		
		
		
			
			ad.clickAttachfilebutton();
			logger.info("click on attach file");
			ad.clickchoosefilebutton("Location");
			logger.info("file is attached");
			logger.info("saved event");
		}*/
		@Test(priority=12)
		public void editOpportunityStage() {
			OpportunityCreationTab ot=new OpportunityCreationTab(driver);
			ot.clickEdit();
			logger.info("clicked on edit opportunity");
			ot.setStage(p.getProperty("closestage"));
			logger.info("Choosing closed won");
			ot.clickSaveButton();
			logger.info("saved opportunity");
			
		}
		@Test(priority = 13)
	    public void Validate_opp() {
		//oc.Validate();
		try {
	    logger.info("validate the error message in closed won when openactivites status is not in done");
		
	    EroorValidation oc= new EroorValidation(driver);
	    boolean exp=oc.Validate_Error();
		AssertJUnit.assertEquals(false, exp);
		logger.error("TEST FAILED");
	    }
		
		catch(Exception e) {
			
			Assert.fail();
		}
	}
	    
	    @Test(priority = 14)
	    
	    public void Validate_Status() {
	    	//oc.validate_closed_won();
	       logger.info("Validate the error message closed won when openactivites status is done");
	       EroorValidation oc= new EroorValidation(driver);
	       String expError=oc.getErrorMessage();
	 	   String actError="Closed Won";
	 	   AssertJUnit.assertEquals(expError,actError);
	 	   logger.info("*****finish testing******");
	    }
	    

		

}
