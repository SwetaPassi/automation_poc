package com.mint.qa.pages;

import com.mint.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProposalPage extends TestBase{


    @FindBy(xpath = "//span[contains(text(),'Proposal')]")
    WebElement Proposals;

    @FindBy(xpath="//span[contains(text(),'My Proposal')]")
    WebElement My_Proposal_Page;

    @FindBy(xpath="//input[@type='Search Proposals']")
    WebElement SearchText_Channel;

    @FindBy(id="searchProducts")
    WebElement Search_Proposal;

    @FindBy(xpath="//button[contains(text(),'Save')]")
    WebElement save_proposal;


    @FindBy(xpath="//button[contains(text(),'Draft')]")
    WebElement Proposal_Draft;

    @FindBy(xpath="//button[contains(text(),'Under Review')]")
    WebElement Proposal_UnderReview;

    @FindBy(xpath="//button[contains(text(),'Under Approval')]")
    WebElement Proposal_UnderApprovalt;

    @FindBy(xpath="//button[contains(text(),'Approved')]")
    WebElement Proposal_Approved;


    @FindBy(xpath="//button[contains(text(),'Cancel')]")
    WebElement cancel_proposal;

    @FindBy(id="createProposal")
    WebElement CreateProposal;

    @FindBy(id="react-select-2--value")
    WebElement Advertiser;

    @FindBy(xpath="//input[conntains'react-select-2--option--0']")
    WebElement Advertiser_Selection;

    @FindBy(id="react-select-3--value")
    WebElement Agency;

    @FindBy(id="react-select-4--value")
    WebElement Region;

    @FindBy(id="react-select-5--value")
    WebElement Currency;


    @FindBy(id="react-select-6--value")
    WebElement ProposalType;

    @FindBy(id="react-select-7--value")
    WebElement ProposalCategory;

    @FindBy(id="react-select-8--value")
    WebElement MasterProposal;

    @FindBy(id="react-select-10--value")
    WebElement PrimaryTGMarket;

    @FindBy(id="react-select-11--value")
    WebElement SecondaryTGMarket;


    @FindBy(id="react-select-12--value")
    WebElement Brand;

    @FindBy(xpath="//select[contains(@class, 'form-control')]")
    WebElement SelectChannel_Proposal;

//    react-datepicker__input-container

    @FindBy(xpath="//img[contains(@alt,'MINT')]")
    WebElement MINTImage;

    @FindBy(xpath="//div[contains(@class,'error-block')]")
    List<WebElement> errorMessage;

    @FindBy(xpath="//span[contains(@class,'Select-clear')]")
    List<WebElement> select_clear;


    // Initializing the Page Objects:
    public ProposalPage()
    {
        PageFactory.initElements(driver, this);
    }


    public void Date_Widget() {
        WebElement dateWidget = driver.findElement(By.xpath("DayPicker-Day"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

        for (WebElement cell : columns) {
            //Select 13th Date
            if (cell.getText().equals("13")) {
                cell.findElement(By.linkText("13")).click();
                break;
            }
        }
    }

    public String verifyProposalPageTitle(){
        return driver.getTitle();
    }

    public String verifyProposalPagURL(){
        return driver.getCurrentUrl();
    }



    public void validatforPageLoad() {
        long timeOut = 80000;
        long end = System.currentTimeMillis() + timeOut;

        while (System.currentTimeMillis() < end) {
            if (String.valueOf(
                    ((JavascriptExecutor) driver)
                            .executeScript("return document.readyState"))
                    .equals("complete") && MINTImage.isDisplayed()) {
                break;
            }
        }
    }

    public String verifyHomePageURL(){
        return driver.getCurrentUrl();
    }

    public void selectChannelName(String name) {
        Select selectByValue = new Select(SelectChannel_Proposal);
        selectByValue.selectByValue(name);
    }

    public String getProposalId(String name)
    {
        String page_url =  driver.getCurrentUrl();
        String[] arrOfStr =  page_url.split("/",10);
        System.out.print(arrOfStr[0]);

        for (String a : arrOfStr)
            System.out.println(a);

        return arrOfStr[7];
    }

    public List<WebElement> errormessage(){
        return errorMessage;
    }


    public List<WebElement> selectClear() {
        return select_clear;
    }

    public void selectAdvertiser(String name) {
        performAction(Advertiser,name);
        selectdropdownoption(name);
    }


    public void selectdropdownoption(String name)
    {
        WebElement dropdownValue = driver.findElement(By.xpath("//*[@role=\"option\" and text()='"+name+"']"));
        dropdownValue.click();
    }

    public void selectAgency(String name)
    {
        performAction(Agency,name);
        selectdropdownoption(name);
    }

    public void selectCurrency(String name)
    {
        performAction(Currency,name);
        selectdropdownoption(name);
    }

    public void selectRegion(String name)
    {
        performAction(Region,name);
        selectdropdownoption(name);
    }

    public void selectProposalType(String name)
    {
        performAction(ProposalType,name);
        selectdropdownoption(name);
    }

    public void selectMasterProposal(String name) {
        performAction(MasterProposal,name);
        selectdropdownoption(name);
    }

    public void selectPrimaryTGMarket(String name) {
        performAction(PrimaryTGMarket,name);
        selectdropdownoption(name);
    }

    public void selectSecondaryTGMarket(String name) {
        performAction(SecondaryTGMarket,name);
        selectdropdownoption(name);
    }

    public void selectProposalCategory(String name) {
        performAction(ProposalCategory,name);
        selectdropdownoption(name);
    }

    public void ClearProposalCategory(String name) {
        performClearAction(ProposalCategory);
    }

    public void ClearProposalType() {
        performClearAction(ProposalType);
    }

    public void selectBrand(String name) {
        performAction(Brand,name);
        selectdropdownoption(name);
    }

    public void CreateProposal() {
        Actions actions = new Actions(driver);
        actions.moveToElement(CreateProposal).click().perform();
    }

    public void SelectDraft_Proposal() {
        Proposal_Draft.click();
    }

    public void SelectUnderRreview_Proposal() {
        Proposal_UnderReview.click();
    }

    public void SelectUnderApproval_Proposal() {
        Proposal_UnderApprovalt.click();
    }

    public void SelectApproved_Proposal() {
        Proposal_Approved.click();
    }




    public void addProposalType(String Advertiser,String Agencies,String Currency,String Region,String ProposalType,String Deal_Start_Date,String DealEnd_Date,String Rating) throws InterruptedException {
        selectAdvertiser(Advertiser);
        selectAgency(Agencies);
        selectRegion(Region);
        selectCurrency(Currency);
        selectProposalType(ProposalType);

        select_date(Deal_Start_Date);
        select_date(DealEnd_Date);
        //     select_rating(Rating);
        save_proposal.click();
        //       validatforPageLoad();
        Thread.sleep(6000);

        //   Boolean val = (new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains("https://stage-adsales.startv.com/app/channels/4/proposals/new"));
        //   System.out.print("Value to be printed"+driver.getCurrentUrl());
    }

    public void addProposalCategory(String Advertiser,String Agencies,String Currency,String Region,String ProposalCategory,String Deal_Start_Date,String DealEnd_Date,String Rating) throws InterruptedException {
        selectAdvertiser(Advertiser);
        selectAgency(Agencies);
        selectRegion(Region);
        selectCurrency(Currency);
        clearSection(8);
        clearSection(12);
        selectProposalCategory(ProposalCategory);
        select_date(Deal_Start_Date);
        select_date(DealEnd_Date);
        Thread.sleep(2000);
        //     select_rating(Rating);
        save_proposal.click();
        //       validatforPageLoad();
        Thread.sleep(5000);

        //   Boolean val = (new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains("https://stage-adsales.startv.com/app/channels/4/proposals/new"));
        //   System.out.print("Value to be printed"+driver.getCurrentUrl());
    }

    public void save_proposal()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(save_proposal).click().perform();

    }

    public void performAction(WebElement name,String value) {
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        actions.click();
        actions.sendKeys(value);
        actions.build().perform();
        actions.click();
    }

    public void performClearAction(WebElement name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        actions.click();
        actions.sendKeys("");
        actions.build().perform();
        actions.click();
    }
    public boolean validateErrorMessage(String message)
    {
        for(int i = 0; i< errormessage().size();i++)
        {
            if(errormessage().get(i).getText().matches(message)) {
                return true;
            }
        }
        return false;
    }

    public void clearSection(int value)
    {
        select_clear.get(value).click();
    }

    public void select_date(String calendar_date) {
        //  driver.findElement(By.xpath("react-datepicker__input-container")).click();
        driver.findElement(By.xpath("(//div[@class='react-datepicker__input-container'])[1]")).click();

        selectdropdownoption(calendar_date);
        driver.findElement(By.xpath("(//div[@class='react-datepicker__input-container'])[2]")).click();

        selectdropdownoption(calendar_date);

    }


    public void select_rating(Integer calendar_date) {
        driver.findElement(By.xpath("//button[contains(@class,'DayPicker-Day') and contains(@aria-label,'"+calendar_date+"')]")).click();
    }


    public void perform_Action(WebElement name,String value) {
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        actions.click();
        actions.build().perform();
    }
}
