package com.mint.qa.testcases;

import com.mint.qa.base.TestBase;
import com.mint.qa.pages.HomePage;
import com.mint.qa.pages.LoginPage;
import com.mint.qa.pages.StarHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	StarHomePage starHomePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		initialization();
		starHomePage = new StarHomePage();
		loginPage = starHomePage.StarHome();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "JoshSoftware-dev-979163 - Sign In");
	}
	
	@Test(priority=1)
	public void loginTestasSuperUser(){
		homePage = loginPage.login(prop.getProperty("superadmin_username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void loginTestasSalesFrontLine(){
		homePage = loginPage.login(prop.getProperty("sales_operation"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void loginTestasPRS_User(){
		homePage = loginPage.login(prop.getProperty("product_manager"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void loginTestasSalesOperation_User(){
		homePage = loginPage.login(prop.getProperty("sales_operation"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void loginTestasTrainer_User(){
		homePage = loginPage.login(prop.getProperty("trainer"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void loginTestasSalesManager_User(){
		homePage = loginPage.login(prop.getProperty("sales_manager"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void loginTest_as_centralteam_executive(){
		homePage = loginPage.login(prop.getProperty("centralteam_executive"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void loginTest_as_sales_management(){
		homePage = loginPage.login(prop.getProperty("senior_management"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
