package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.cybertek.utilities.BrowserUtils.*;

public class CreatingTaskDefs {
    Pages pages=new Pages();

    @When("I click on New Task")
    public void i_click_on_New_Task() {
        hover(pages.tasksPage().tasks);
        pages.tasksPage().createTask.click();
        waitForUIOverlay();
    }

    @Then("I should be able to see the New Task Window")
    public void i_should_be_able_to_see_the_New_Task_Window() {
        Assert.assertTrue(Driver.get().findElement
                (By.cssSelector("div[class='side-panel side-panel-container side-panel-container-open']")).isDisplayed());//does not work
    }

    @When("I click on Upload Files")
    public void iClickOnUploadFiles() {
        //hover(pages.tasksPage().uploadFiles);
        waitForClickability(pages.tasksPage().uploadFiles, 10);
        pages.tasksPage().uploadFiles.click();
    }


    @Then("I see four options to upload files")
    public void iSeeFourOptionsToUploadFiles() {
        Assert.assertTrue(pages.tasksPage().tableWithUploadFilesOptions.isDisplayed());
    }
}
