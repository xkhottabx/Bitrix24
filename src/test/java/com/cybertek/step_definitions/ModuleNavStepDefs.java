package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class ModuleNavStepDefs {

    Pages pages=new Pages();

    @When("I click a {string}")
    public void iClickA(String module) {
        pages.homePage().switchToModule(module);
    }


    @Then("The title should be {string}")
    public void theTitleShouldBe(String title) {
        Assert.assertEquals(title, Driver.get().getTitle());
    }
}
