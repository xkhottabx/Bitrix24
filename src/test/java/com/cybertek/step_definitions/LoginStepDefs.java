package com.cybertek.step_definitions;


import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.cybertek.utilities.BrowserUtils.*;


public class LoginStepDefs {
    Pages pages=new Pages();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("I login as a user")
    public void i_login_as_a_user() {
        pages.loginPage().logIn(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @Then("I should be able to see the user name on the Home Page")
    public void i_should_be_able_to_see_the_user_name_on_the_Home_Page() {
       Assert.assertTrue(loginVerification(ConfigurationReader.get("username")));
    }
}
