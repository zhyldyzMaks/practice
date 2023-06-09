package com.OpenMRS.stepdefs;

import com.OpenMRS.pages.HomePage;
import com.OpenMRS.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

import java.sql.Driver;

public class LoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("User navigates to the webpage and user validates the title {string}")
    public void user_navigates_to_the_webpage_and_user_validates_the(String title) throws InterruptedException {
        Assert.assertEquals(title, driver.getTitle().trim());
        Thread.sleep(1000);
    }
    @When("User enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        loginPage.login(ConfigReader.readProperty("username"),ConfigReader.readProperty("password"));

    }
    @When("User chooses location {string}")
    public void user_chooses_location(String location) {
        loginPage.chooseLocation(location);
    }
    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
       loginPage.clickLoginButton();
    }
    @Then("User validates the header contains text {string}")
    public void user_validates_the_header_contains_text(String user) {
        Assert.assertTrue(homePage.validateHeader().contains(user));
    }

    @Then("User validates the header which contains text {string}")
    public void user_validates_the_header_which_contains_text(String location) {
        Assert.assertTrue(homePage.validateHeader().contains(location));

    }
    @Then("User clicks on logout button")
    public void user_clicks_on_logout_button() {
       homePage.clickLogOutButton();
    }

    //Login functionality with Negative Credentials

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
       loginPage.login(username,password);
    }
    @When("User chooses a location {string} and clicks the login button")
    public void user_chooses_a_location_and_clicks_the_login_button(String location) {
        loginPage.chooseLocation(location);
        loginPage.clickLoginButton();
    }
    @Then("User validates the error message {string}")
    public void user_validates_the_error_message(String errorMessage) {
        Assert.assertEquals(errorMessage,loginPage.validateErrorMessage());
    }
}
