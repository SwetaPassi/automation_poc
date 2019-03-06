package com.mint.qa.testcases;

import com.mint.qa.base.TestBase;
import com.mint.qa.pages.*;
import com.mint.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Calendar;

public class ProposalBriefPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ChannelPage contactsPage;
    StarHomePage starHomePage;
    ProposalPage proposal_page;
    public static String Advertiser = "Basak Book Store";
    public static String Advertiser1 = "Bookmyshow.Com";

    public static String Agencies = "PUNJABI MEDIA INC";
    public static String Currencies = "Indian Rupees";
    public static String Region1 = "NORTH";
    public static String Region = "EAST";
    public static String Current_Date = null;
    public static String Rating = "";
    public static String Channel_Id = "4";

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
    public String Proposal_Setup(String Channel_id)  {
        homePage.validatforPageLoad();
        proposal_page = homePage.GotoProoposalPage();
        proposal_page.validatforPageLoad();
        proposal_page.selectChannelName(Channel_id); // Star Plus
        proposal_page.CreateProposal();
        proposal_page.validatforPageLoad();
        Calendar calendar = Calendar.getInstance();
        Current_Date = String.valueOf(calendar.get(Calendar.DATE));
        return  proposal_page.verifyProposalPageTitle();
    }


    @Test(priority=1)
    public void verifyProposalBriefPage_ValidationTest() throws InterruptedException {

        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.validatforPageLoad();
        proposal_page.save_proposal();
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
        Assert.assertEquals(8,proposal_page.errormessage().size());
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        Assert.assertTrue(proposal_page.validateErrorMessage("proposal type or proposal category must be present"));


    }


    @Test(priority=1)
    public void verifyProductType_CPRP_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Campaign CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyProductType_CPRP_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Campaign CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyProductType_CPRP_ProposalBriefPageTest_asSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Campaign CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_CPRP_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Campaign CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Campaign_ER_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Campaign ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }


    @Test(priority=1)
    public void verifyProductType_Campaign_ER_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Campaign ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyCampaign_ER_ProposalBriefPageTest_asSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Campaign ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyCampaign_ER_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Campaign ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }


    @Test(priority=1)
    public void verifyProductType_LongTerm_ER_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Long Term ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }


    @Test(priority=1)
    public void verifyProductType_LongTerm_ER_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Long Term ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verity_ProductType_LongTerm_ER_ProposalBriefPageTest_asSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief =   Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Long Term ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_LongTerm_ER_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Long Term ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Master_CPRP_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Master CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }


    @Test(priority=1)
    public void verifyProductType__Master_CPRP_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductType__MasterCPRP_ProposalBriefPageTest_aSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Master_CPRP_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Master_ER_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Master ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }


    @Test(priority=1)
    public void verifyProductType__Master_ER_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductType__MasterER_ProposalBriefPageTest_asSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Master_ER_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Master_Rate_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Master Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }


    @Test(priority=1)
    public void verifyProductType__Master_Rate_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductType__MasterRate_ProposalBriefPageTest_asSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Master_Rate_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Master Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Sub_Deals_CPRP_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Sub Deals CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType__Sub_Deals_CPRP_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType__Sub_Deals_CPRP_ProposalBriefPageTest_asSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Sub_Deals_CPRP_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals CPRP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("Ratings can't be blank"));
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Sub_Deals_ER_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Sub Deals ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();

        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType__Sub_Deals_ER_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType__Sub_Deals_ER_ProposalBriefPageTest_asSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Sub_Deals_ER_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals ER",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Sub_Deals_Rate_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser1,Agencies,Currencies,Region1,"Sub Deals Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType__Sub_Deals_Rate_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductType__Sub_Deals_Rate_ProposalPageTestSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductType_Sub_Deals_Rate_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalType(Advertiser,Agencies,Currencies,Region,"Sub Deals Rate",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyProductCategory_AdditionalMonies_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        System.out.print( "\nProposal Title After Creation -------------"+ProposalBrief);

        proposal_page.addProposalCategory(Advertiser1,Agencies,Currencies,Region1,"Additional Monies",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        String ProposalBrief1 = proposal_page.verifyProposalPageTitle();
        proposal_page.validatforPageLoad();
        System.out.print( "\nProposal Title After Creation -------------"+ ProposalBrief1);
        Assert.assertEquals(ProposalBrief,ProposalBrief1);
    }

    @Test(priority=1)
    public void verifyProductCategory_AdditionalMonies_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Additional Monies",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductCategory_AdditionalMonies_ProposalPageTestSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Additional Monies",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductCategory_AdditionalMonies_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Additional Monies",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyProductCategory_Compensation_Bonus_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser1,Agencies,Currencies,Region1,"Compensation/Bonus",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        String ProposalBrief1 = proposal_page.verifyProposalPageTitle();
        proposal_page.validatforPageLoad();
        System.out.print( "\nProposal Title After Creation -------------"+ ProposalBrief1);

        Assert.assertEquals(ProposalBrief,ProposalBrief1);

    }

    @Test(priority=1)
    public void verifyProductCategory_CompensationBonus_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Compensation/Bonus",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductCategory_CompensationBonus_ProposalPageTestSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Compensation/Bonus",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductCategory_CompensationBonus_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Compensation/Bonus",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertTrue(proposal_page.validateErrorMessage("can't be blank"));
        proposal_page.validatforPageLoad();
        Assert.assertEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }


    @Test(priority=1)
    public void verifyProductCategory_Combo_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser1,Agencies,Currencies,Region1,"Combo",Current_Date,Current_Date,"Tue Jan 08 2019");
        String ProposalBrief1 = proposal_page.verifyProposalPageTitle();
        proposal_page.validatforPageLoad();
        System.out.print( "\nProposal Title After Creation -------------"+ ProposalBrief1);

        Assert.assertNotEquals(ProposalBrief,ProposalBrief1);

    }

    @Test(priority=1)
    public void verifyProductCategory_Combo_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Combo",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductCategory_Combo_ProposalPageTestSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Combo",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductCategory_Combo_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Combo",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyProductCategory_DAVP_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser1,Agencies,Currencies,Region1,"DAVP",Current_Date,Current_Date,"Tue Jan 08 2019");
        String ProposalBrief1 = proposal_page.verifyProposalPageTitle();
        proposal_page.validatforPageLoad();
        System.out.print( "\nProposal Title After Creation -------------"+ ProposalBrief1);
        Assert.assertNotEquals(ProposalBrief,ProposalBrief1);
    }

    @Test(priority=1)
    public void verifyProductCategory_DAVP_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"DAVP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductCategory_DAVP_ProposalPageTestSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"DAVP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductCategory_DAVP_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"DAVP",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }


    @Test(priority=1)
    public void verifyProductCategory_OnlySponsorShip_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser1,Agencies,Currencies,Region1,"Only Sponsorships",Current_Date,Current_Date,"Tue Jan 08 2019");
        String ProposalBrief1 = proposal_page.verifyProposalPageTitle();
        proposal_page.validatforPageLoad();
        System.out.print( "\nProposal Title After Creation -------------"+ ProposalBrief1);
        Assert.assertNotEquals(ProposalBrief,ProposalBrief1);

    }

    @Test(priority=1)
    public void verifyProductCategory_OnlySponsorShip_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Only Sponsorships",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verityProductCategory_OnlySponsorships_ProposalPageTestSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Only Sponsorships",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());

    }

    @Test(priority=1)
    public void verifyProductCategory_OnlySponsorships_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Only Sponsorships",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyProductCategory_OnlyElements_ProposalBriefPageTest_asSalesFrontLine() throws InterruptedException {
        homePage = loginPage.loginas("sales_frontline");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser1,Agencies,Currencies,Region1,"Only Elements",Current_Date,Current_Date,"Tue Jan 08 2019");
        String ProposalBrief1 = proposal_page.verifyProposalPageTitle();
        proposal_page.validatforPageLoad();
        System.out.print( "\nProposal Title After Creation -------------"+ ProposalBrief1);
        Assert.assertNotEquals(ProposalBrief,ProposalBrief1);

    }

    @Test(priority=1)
    public void verifyProductCategory_OnlyElements_ProposalBriefPageTest_asProductManager() throws InterruptedException {
        homePage = loginPage.loginas("product_manager");
        String ProposalBrief =  Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Only Elements",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verityProductCategory_OnlyElements_ProposalPageTestSales_manager() throws InterruptedException {
        homePage = loginPage.loginas("sales_manager");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Only Elements",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }

    @Test(priority=1)
    public void verifyProductCategory_OnlyElements_ProposalBriefPageTest_asSuperAdmin() throws InterruptedException {
        homePage = loginPage.loginas("superadmin_username");
        String ProposalBrief = Proposal_Setup(Channel_Id);
        proposal_page.addProposalCategory(Advertiser,Agencies,Currencies,Region,"Only Elements",Current_Date,Current_Date,"Tue Jan 08 2019");
        proposal_page.validatforPageLoad();
        Assert.assertNotEquals(ProposalBrief,proposal_page.verifyProposalPageTitle());
    }


    @AfterMethod
    public void tearDown(){
        homePage.closebrowser();
    }

}
