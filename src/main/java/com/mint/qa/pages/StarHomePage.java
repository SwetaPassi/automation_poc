package com.mint.qa.pages;

import com.mint.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StarHomePage extends TestBase {

    //Page Factory - OR:
    @FindBy(xpath="//button[contains(text(),'Login With')]")
    WebElement SignUpBtn;

    //Initializing the Page Objects:
    public StarHomePage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateStarHomePageTitle(){
        return driver.getTitle();
    }

    public LoginPage StarHome() throws InterruptedException {
        //loginBtn.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", SignUpBtn);
        return new LoginPage();
    }

}
