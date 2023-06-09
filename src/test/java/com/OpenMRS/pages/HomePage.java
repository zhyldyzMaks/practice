package com.OpenMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "h4")
    WebElement header;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//i[@class='icon-user']//..")
    WebElement registerPatientButton;
    public String validateHeader(){
        return BrowserUtils.getText(header);
    }

    public void clickLogOutButton(){
        logoutButton.click();
    }

    public void clickRegisterPatientButton(){
        registerPatientButton.click();
    }

}
