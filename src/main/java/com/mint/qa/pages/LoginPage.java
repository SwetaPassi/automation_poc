package com.mint.qa.pages;

import com.mint.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

	HomePage homePage;
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'auth-org-logo')]")
	WebElement crmLogo;


	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}

	public HomePage loginas(String value)
	{
		if(value.matches("superadmin_username")) {
			login(prop.getProperty("superadmin_username"), prop.getProperty("password"));
		}
		else if (value.matches("product_manager")) {
			login(prop.getProperty("product_manager"), prop.getProperty("password"));
		}
		else if (value.matches("salesoperation")) {
			login(prop.getProperty("sales_operation"), prop.getProperty("password"));
		}
		else if (value.matches("trainer")) {
			login(prop.getProperty("trainer"), prop.getProperty("password"));
		}
		else if (value.matches("sales_manager")) {
			login(prop.getProperty("sales_manager"), prop.getProperty("password"));
		}else if (value.matches("centralteam_executive")) {
			login(prop.getProperty("centralteam_executive"), prop.getProperty("password"));

		}else if (value.matches("senior_management"))
		{
			login(prop.getProperty("senior_management"), prop.getProperty("password"));
		}
		else if (value.matches("data_product"))
		{
			login(prop.getProperty("data_product"), prop.getProperty("password"));
		}
		else if (value.matches("sales_frontline"))
		{
			login(prop.getProperty("sales_frontline"), prop.getProperty("password"));
		}
		else {

		}
		return new HomePage();
	}

}
