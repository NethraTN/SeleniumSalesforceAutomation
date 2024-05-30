package testBases;


import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {



	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	public Robot robot;
	@BeforeClass
	public void Setup() throws IOException, AWTException {
		//LOADING properties file
		FileReader file=new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		//LOADING log4j2file
		logger=LogManager.getLogger(this.getClass());
		driver= new ChromeDriver();
		robot=new Robot();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
		

	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

	@AfterClass
	public void closebrowser(){
		driver.close();
}
	
	
	
	
	
	




}

