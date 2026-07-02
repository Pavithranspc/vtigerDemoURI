package org.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy (xpath = "//input[@id='username']")
	private WebElement UserNameTextField;
	
	@FindBy (xpath = "//input[@id='inputPassword']")
	private WebElement PasswordTextField;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement SignInButton;
	
	//Initialization
	public LoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}

	//getters
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getSignInButton() {
		return SignInButton;
	}
	
	

	
	public void login(String USERNAME, String PASSWORD) {
		
//		loginpage.getUserNameTextField().sendKeys(USERNAME);
//		loginpage.getPasswordTextField().sendKeys(PASSWORD);
//		loginpage.getSignInButton().submit();

		UserNameTextField.sendKeys(USERNAME);
		PasswordTextField.sendKeys(PASSWORD);
		SignInButton.submit();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
