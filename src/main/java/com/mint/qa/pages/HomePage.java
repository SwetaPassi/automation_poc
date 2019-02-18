package com.mint.qa.pages;

import com.mint.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class HomePage extends TestBase {

	public static int channel_id = 55;

	HashMap<String,String> hmap_landingPage = new HashMap<String,String>();

	@FindBy(xpath = "//span[contains(text(),'Notifications')]")
	WebElement Notification;

	@FindBy(xpath = "//span[contains(text(),'Funnel')]")
	WebElement Funnel;

	@FindBy(xpath = "//span[contains(text(),'Configurator')]")
	WebElement Configurator;

	@FindBy(xpath = "//span[contains(text(),'Proposal')]")
	WebElement Proposals;

	@FindBy(xpath = "//span[contains(text(),'My Acccount')]")
	WebElement My_Account;

	@FindBy(xpath = "//span[contains(text(),'Admin Tasks')]")
	WebElement Admin_tasks;

	@FindBy(xpath = "//span[contains(text(),'Download')]")
	WebElement Download;

	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	WebElement Reports;

	@FindBy(xpath = "//span[contains(text(),'Delegation')]")
	WebElement delegation;

	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	WebElement Logout;

	@FindBy(xpath = "//span[contains(text(),'Support')]")
	WebElement Support;

	@FindBy(xpath="//[contains(@class,'modal-content')]")
	WebElement notification_window;

	@FindBy(xpath="//span[contains(text(),'My Proposal')]")
	WebElement My_Proposal_Page;



	// Initializing the Page Objects:
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public HashMap<String,String> landing_Page() {
		String landingPage = "https://stage-adsales.startv.com/app/";
		hmap_landingPage.put("Channel",landingPage+"channels");
		hmap_landingPage.put("Funnel",landingPage+"funnels");
		hmap_landingPage.put("Proposal",landingPage+"");
		hmap_landingPage.put("ProposalApproval",landingPage+"channels/"+channel_id+"/proposals/approvals");
		hmap_landingPage.put("ProposalSummary",landingPage+"/channels/"+channel_id+"/proposals/summary");
		hmap_landingPage.put("Configurator",landingPage+"channels/"+channel_id+"/products");
		hmap_landingPage.put("Proposal_LandingPage",landingPage+ "channels/27/proposals/approvals");
		hmap_landingPage.put("OptimizerRule",landingPage+"/channels/55/optimizer_rules/price_breakage");
		return hmap_landingPage;
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verify_Notification_Section()
	{
	//	clickOnNotifcation_Section();
		return Notification.isDisplayed();
	}

	public boolean verify_Support(){
//		clickOnSupport();
		return Support.isDisplayed();
	}

	public boolean verify_Funnel_Section(){
		clickOnFunnel_Section();
		return Funnel.isDisplayed();
	}

	public boolean verify_Configurator_Section(){
		clickOnConfigurator();
		return Configurator.isDisplayed();
	}

	public boolean verify_Proposals_Section(){
		clickOnProposals();
		clickOnMyProposal();
		return Proposals.isDisplayed();
	}

	public boolean verify_MyAccount_SEction(){
		clickOnMyAccount();
		return My_Account.isDisplayed();
	}

	public boolean verify_Admin_tasks_Section(){
		clickOnAdMinTask();
		return Admin_tasks.isDisplayed();
	}

	public boolean verify_Downlkoad_Section_(){
	//	clickOnDownload();
		return Download.isDisplayed(); }

	public boolean verify_Reports_Section(){
		clickOnReport();
		return Reports.isDisplayed();
	}

	public boolean verify_Delegation_Section(){
		return delegation.isDisplayed();
	}

	public boolean verify_Logout_Section(){ return Logout.isDisplayed(); }

	public boolean verifyNotificationModal() {

		return notification_window.isDisplayed();
	}

	public void clickOnNotifcation_Section()
	{
		Notification.click();

	}

	public void clickOnFunnel_Section(){
		Funnel.click();
	}


	public void clickOnConfigurator(){
		Configurator.click();
	}

	public void clickOnProposals(){
		Proposals.click();
	}

	public void clickOnMyProposal(){
		My_Proposal_Page.click();
	}

	public void clickOnMyAccount(){
		My_Account.click();
	}

	public void clickOnAdMinTask(){
		Admin_tasks.click();
	}

	public void clickOnDownload(){
		Download.click();
	}

	public void clickOnReport(){
		Reports.click();
	}

	public void clickOnDelegation(){
		delegation.click();
	}

	public void clickOnSupport(){
		Support.click();
	}

	public void clickOnLogout(){
		Logout.click();
	}
	
	/*public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}*/
}
