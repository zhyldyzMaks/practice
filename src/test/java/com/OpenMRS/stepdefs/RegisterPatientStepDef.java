package com.OpenMRS.stepdefs;

import com.OpenMRS.pages.HomePage;
import com.OpenMRS.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class RegisterPatientStepDef {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("user navigates to OpenMRS system, enters username and password, chooses location {string} and logs into the webpage")
    public void user_navigates_to_open_mrs_system_enters_username_and_password_chooses_location_and_logs_into_the_webpage(String location) {
        loginPage.login(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        loginPage.chooseLocation(location);
        loginPage.clickLoginButton();
    }

    @When("user clicks on the Register a patient button.")
    public void user_clicks_on_the_register_a_patient_button() {
        homePage.clickRegisterPatientButton();
    }
    @When("user clicks on Name button and enters first name {string} and last name {string}")
    public void user_clicks_on_name_button_and_enters_first_name_and_last_name(String string, String string2) {

    }
    @When("user clicks on Gender button and chooses the gender")
    public void user_clicks_on_gender_button_and_chooses_the_gender() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on Birthday button and provides the date of birth")
    public void user_clicks_on_birthday_button_and_provides_the_date_of_birth() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on Address button and provides the address details")
    public void user_clicks_on_address_button_and_provides_the_address_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on Phone Number button and provides the phone number")
    public void user_clicks_on_phone_number_button_and_provides_the_phone_number() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks the confirm button on a left side and validates the entries displayed are correct")
    public void user_clicks_the_confirm_button_on_a_left_side_and_validates_the_entries_displayed_are_correct() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks green confirm button and validates the patient information is correct")
    public void user_clicks_green_confirm_button_and_validates_the_patient_information_is_correct() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
