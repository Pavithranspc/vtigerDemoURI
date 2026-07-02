package org.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	//Declaration
	@FindBy (xpath = "//input[@name='campaignName']")
	private WebElement CampaignNameTextField;

	@FindBy (xpath = "//input[@name='campaignStatus']")
	private WebElement CampaignStatusTextField;

	@FindBy (xpath = "//input[@name='targetSize']")
	private WebElement TargetSizeTextField;

	@FindBy (xpath = "//input[@name='expectedCloseDate']")
	private WebElement ExpectedCloseDateTextField;

	@FindBy (xpath = "//input[@name='targetAudience']")
	private WebElement TargetAudienceTextField;

	@FindBy (xpath = "//input[@name='description']")
	private WebElement DescriptionTextField;

	@FindBy (xpath = "//button[text()='Create Campaign']")
	private WebElement CreateCampaignButton;
	
	//Initialization
	public CreateCampaignPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	//getters
	public WebElement getCampaignNameTextField() {
		return CampaignNameTextField;
	}

	public WebElement getCampaignStatusTextField() {
		return CampaignStatusTextField;
	}

	public WebElement getTargetSizeTextField() {
		return TargetSizeTextField;
	}

	public WebElement getExpectedCloseDateTextField() {
		return ExpectedCloseDateTextField;
	}

	public WebElement getTargetAudienceTextField() {
		return TargetAudienceTextField;
	}

	public WebElement getDescriptionTextField() {
		return DescriptionTextField;
	}

	public WebElement getCreateCampaignButton() {
		return CreateCampaignButton;
	}
	
	
	
	
	
	public void mandatoryFields(String CAMPAIGNNAME, String TARGETSIZE) {
		
		CampaignNameTextField.sendKeys(CAMPAIGNNAME);
		TargetSizeTextField.sendKeys(TARGETSIZE);
		CreateCampaignButton.submit();
		
	}
	
	
	
	
	
	
	
	

}
