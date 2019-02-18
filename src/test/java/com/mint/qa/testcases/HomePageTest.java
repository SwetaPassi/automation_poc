package com.mint.qa.testcases;

import com.mint.qa.base.TestBase;
import com.mint.qa.pages.ChannelPage;
import com.mint.qa.pages.HomePage;
import com.mint.qa.pages.LoginPage;
import com.mint.qa.pages.StarHomePage;
import com.mint.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ChannelPage contactsPage;
	StarHomePage starHomePage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browse
	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ChannelPage();
		loginPage = new LoginPage();
		starHomePage = new StarHomePage();
		loginPage = starHomePage.StarHome();
	//	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		homePage = loginPage.loginas("salesoperation");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "JoshSoftware-dev-979163 - Sign In","Home page title not matched");
	}


	@Test(priority=1)
	public void verifyHomePageasSalesUser() throws InterruptedException {
		homePage = loginPage.loginas("salesoperation");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Admin_tasks_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Delegation_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verifyNotificationModal());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}

	@Test(priority=1)
	public void verifyHomePageasSalesManager() throws InterruptedException {
		homePage = loginPage.loginas("sales_manager");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Delegation_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());
	}

	@Test(priority=1)
	public void verifyHomePageasProductManager() throws InterruptedException {
		homePage = loginPage.loginas("product_manager");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Admin_tasks_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Delegation_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());
	}

	@Test(priority=1)
	public void verifyHomePageas_CT_executive() throws InterruptedException {
		homePage = loginPage.loginas("centralteam_executive");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Admin_tasks_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}

	@Test(priority=1)
	public void verifyHomePageassenior_management() throws InterruptedException {
		homePage = loginPage.loginas("senior_management");
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());
	}

	@Test(priority=1)
	public void verifyHomePageastrainer() throws InterruptedException {
		homePage = loginPage.loginas("trainer");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Delegation_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}

	@Test(priority=1)
	public void verifyHomePageassuperadmin_username() throws InterruptedException {
		homePage = loginPage.loginas("superadmin_username");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Admin_tasks_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}

	@Test(priority=1)
	public void verifyHomePageasData_Product() throws InterruptedException {
		homePage = loginPage.loginas("data_product");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Admin_tasks_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}

	@Test(priority=1)
	public void verifyHomePageasSalesFrontLine() throws InterruptedException {
		homePage = loginPage.loginas("sales_frontline");
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}
	
//	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
	//	contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
