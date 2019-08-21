package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.cybertek.utilities.BrowserUtils.*;

public class CreatingTaskDefs {
    Pages pages=new Pages();



    @When("I click on New Task")
    public void i_click_on_New_Task() {
        hover(pages.tasksPage().tasks);
        pages.tasksPage().createTask.click();
        waitForUIOverlay();
        pages.tasksPage().switchToNewTaskWindow();
    }

    @Then("I should be able to see the New Task Window")
    public void i_should_be_able_to_see_the_New_Task_Window() {
        Assert.assertEquals("Failed, 'New task' window did not come up", Driver.get().getCurrentUrl(),  "https://login.nextbasecrm.com/company/personal/user/513/tasks/task/edit/0/");

    }

    @When("I click on Upload Files")
    public void iClickOnUploadFiles() {

        pages.tasksPage().uploadFiles.click();
    }

    @Then("I see four options to upload files")
    public void iSeeFourOptionsToUploadFiles() {
        Assert.assertTrue(pages.tasksPage().tableWithUploadFilesOptions.isDisplayed());
    }

    @When("I click on Link")
    public void iClickOnLink() {
        pages.tasksPage().linkURL.click();
    }

    @Then("Link window should appear")
    public void linkWindowShouldAppear() {
        Assert.assertTrue(pages.tasksPage().linkURLWindow.isDisplayed());
        pages.tasksPage().closeLinkURLWindow.click();
    }

    @When("I click on Checklist")
    public void iClickOnChecklist() {
        pages.tasksPage().checklist.click();
    }

    @Then("Checklist window should appear")
    public void checklistWindowShouldAppear() {
        pages.tasksPage().addToChecklist.click();
    }

    @When("I click on Activity stream")
    public void iClickOnActivityStream() {
        pages.homePage().activityStream.click();
        waitForUIOverlay();
    }
}
