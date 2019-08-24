package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class HrAppStepDefs {
    private WebDriver driver= Driver.get();
    @Given("I am on Dept page")
    public void i_am_on_Dept_page() {
        // GO TO PAGE

    }

    @When("Search for dep_id {int}")
    public void search_for_dep_id(Integer int1) {
        // get the dep_id
        throw new cucumber.api.PendingException();
    }

    @When("I query Db with SQL {string}")
    public void i_query_Db_with_SQL(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("UI data and DB data must match")
    public void ui_data_and_DB_data_must_match() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
