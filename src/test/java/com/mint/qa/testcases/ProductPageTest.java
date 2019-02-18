/*
 * @author Naveen Khunteta
 * 
 */

package com.mint.qa.testcases;

import com.mint.qa.base.TestBase;
import com.mint.qa.pages.ChannelPage;
import com.mint.qa.pages.HomePage;
import com.mint.qa.pages.LoginPage;
import com.mint.qa.util.TestUtil;
import org.testng.Assert;

import java.net.MalformedURLException;

public class ProductPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ChannelPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ProductPageTest(){
			super();
			
	}
	
	
//	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ChannelPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
	//	contactsPage = homePage.clickOnContactsLink();
	}
	
//	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
//	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
//	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
//	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
//	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
//		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

//	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
