package com.mint.qa.testcases;

import com.mint.qa.base.TestBase;
import com.mint.qa.pages.ChannelPage;
import com.mint.qa.pages.HomePage;
import com.mint.qa.pages.LoginPage;
import com.mint.qa.pages.StarHomePage;
import com.mint.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MINTAuthorizationTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ChannelPage contactsPage;
	StarHomePage starHomePage;

	public MINTAuthorizationTest() {
		super();
	}
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
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
	public void verifyMINT_HomePageTitleTest() throws InterruptedException {
		homePage = loginPage.loginas("salesoperation");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "JoshSoftware-dev-979163 - Sign In","Home page title not matched");
	}


	@Test(priority=1)
	public void verify_MINTSectionsAccess_asSalesUser() throws InterruptedException {
		homePage = loginPage.loginas("salesoperation");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("Proposal_Summary"),homePage.verifyHomePageURL());
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Proposals_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Delegation_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Notification_Section());
		Assert.assertTrue(homePage.verify_Logout_Section());
	}


	@Test(priority=1)
	public void verify_MINTSectionsAccess_asSalesManager() throws InterruptedException {
		homePage = loginPage.loginas("sales_manager");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("ProposalSummary"),homePage.verifyHomePageURL());
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
	public void verify_MINTSectionsAccess_asProductManager() throws InterruptedException {
		homePage = loginPage.loginas("product_manager");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("DPProposalApproval"),homePage.verifyHomePageURL());
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
	public void verify_MINTSectionsAccessas_CT_executive() throws InterruptedException {
		homePage = loginPage.loginas("centralteam_executive");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("OptimizerRule"),homePage.verifyHomePageURL());
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Admin_tasks_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}

	@Test(priority=1)
	public void verify_MINTSectionsAccessas_asSenior_management() throws InterruptedException {
		homePage = loginPage.loginas("senior_management");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("Configurator"),homePage.verifyHomePageURL());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());
	}

	@Test(priority=1)
	public void verify_MINTSectionsAccessas_trainer() throws InterruptedException {
		homePage = loginPage.loginas("trainer");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("Proposal_Summary"),homePage.verifyHomePageURL());
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
	public void verify_MINTSectionsAccessas_asSuperAdmine() throws InterruptedException {
		homePage = loginPage.loginas("superadmin_username");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("Channel"),homePage.verifyHomePageURL());
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
	public void verify_MINTSectionsAccessas_asData_Product() throws InterruptedException {
		homePage = loginPage.loginas("data_product");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("PRSProposalApproval"),homePage.verifyHomePageURL());
		Assert.assertTrue(homePage.verify_Funnel_Section());
		Assert.assertTrue(homePage.verify_Configurator_Section());
		Assert.assertTrue(homePage.verify_Admin_tasks_Section());
		Assert.assertTrue(homePage.verify_Reports_Section());
		Assert.assertTrue(homePage.verify_Downlkoad_Section_());
		Assert.assertTrue(homePage.verify_Support());
		Assert.assertTrue(homePage.verify_Logout_Section());
		Assert.assertTrue(homePage.verify_Notification_Section());

	}

	@Test(priority=1)
	public void verify_MINTSectionsAccess_asSalesFrontLine() throws InterruptedException {
		homePage = loginPage.loginas("sales_frontline");
		homePage.validatforPageLoad();
		Assert.assertEquals(homePage.landing_Page().get("ProposalSummary"),homePage.verifyHomePageURL());
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

	@AfterMethod
	public void tearDown(){
		homePage.closebrowser();
	}
}
