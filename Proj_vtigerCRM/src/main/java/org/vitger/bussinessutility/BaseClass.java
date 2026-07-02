package org.vitger.bussinessutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.vtiger.genericutility.FileUtility;
import org.vtiger.genericutility.JavaUtility;
import org.vtiger.genericutility.WebDriverUtility;
import org.vtiger.objectrepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver = null;
	
	public static WebDriver sdriver = null;
	
	// create object for FileUtility
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	@BeforeSuite (groups = {"smoke","regression"})
	public void beforeSuite() {
		
		Reporter.log("BeforeSuite",true);
		
	}
	
	@AfterSuite  (groups = {"smoke","regression"})
	public void afterSuite() {
		
		Reporter.log("AfterSuite",true);
	}
	
	@BeforeTest  (groups = {"smoke","regression"})
	public void beforeTest() {
		
		Reporter.log("BeforeTest",true);
	}
	
	@AfterTest (groups = {"smoke","regression"})
	public void afterTest() {
		
		Reporter.log("AfterTest",true);
	}

	@BeforeClass  (groups = {"smoke","regression"})
	public void beforeClass() throws IOException {
		Reporter.log("BeforeClass",true);
		
		// read data properties file and store it
		String URL = fUtil.readDataFromPropertiesFile("url");
		String BROWSER = fUtil.readDataFromPropertiesFile("browser");

		//create object for browser specific class
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		} else if(BROWSER.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		} else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		} else {
			
			Reporter.log("Browser Mismatch",true);
		
		}
		
		sdriver = driver;
		

		// create object for WebDriverUtility
		WebDriverUtility wUtil = new WebDriverUtility();

		wUtil.toMaximize(driver);

		wUtil.toImplicitlyWait(driver, 10);

		
		
		
		driver.get(URL);

		
	}
	
	
	@AfterClass  (groups = {"smoke","regression"})
	public void afterClass() {
		Reporter.log("AfterClass",true);
		
		//close browser
		driver.quit();
	}

	
	@BeforeMethod  (groups = {"smoke","regression"})
	public void beforeMethod() throws IOException {
		Reporter.log("BeforeMethod",true);
		
		
		String USERNAME = fUtil.readDataFromPropertiesFile("username");
		String PASSWORD = fUtil.readDataFromPropertiesFile("password");
		
		// create object for LoginPage class
		LoginPage loginpage = new LoginPage(driver);

		loginpage.login(USERNAME, PASSWORD);
		
//		loginpage.getUserNameTextField().sendKeys(USERNAME);
//		loginpage.getPasswordTextField().sendKeys(PASSWORD);
//		loginpage.getSignInButton().submit();

		

	}
	
	@AfterMethod  (groups = {"smoke","regression"})
	public void afterMethod() {
		Reporter.log("AfterMethod",true);
		
		//logout

	}
	
}











