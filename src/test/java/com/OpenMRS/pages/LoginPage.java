package com.OpenMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement usernameBox;

    @FindBy(id = "password")
    WebElement passwordBox;

    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    List<WebElement> locationBox;


    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "error-message")
    WebElement errorMessage;

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);

    }
    public void chooseLocation(String lctn){
        for (WebElement location : locationBox){
            if (BrowserUtils.getText(location).equals(lctn)){
                location.click();
            }
        }
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);
    }


}
