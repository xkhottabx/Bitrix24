package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.NoSuchElementException;

import static com.cybertek.utilities.BrowserUtils.*;

public class CreatingTaskDefs {
    Pages pages=new Pages();
    private String title=new Faker().gameOfThrones().quote();


    @When("I click on New Task")
    public void i_click_on_New_Task() {
        hover(pages.tasksPage().tasks);
        pages.tasksPage().createTask.click();
        waitForUIOverlay();
        pages.tasksPage().switchToNewTaskWindow();
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
        try {
            pages.homePage().switchToModule("Activity Stream");
        }catch (NoSuchElementException e){
            if (Driver.get().getTitle().equalsIgnoreCase("Authorization")){
                System.out.println("Application is not stable at this moment");
            }
            pages.homePage().switchToModule("Activity Stream");
        }

        waitForUIOverlay();
    }

    @When("I click on Task option")
    public void i_click_on_Task_option() {
        pages.tasksPage().taskOption.click();
        waitForUIOverlay();
    }

    @When("I type in Things To Do window")
    public void i_type_in_Things_To_Do_window() {

        pages.tasksPage().inputTaskTitle.sendKeys(title);
    }

    @When("I click Send")
    public void i_click_Send() {
        pages.tasksPage().buttonSendTask.click();
        waitForUIOverlay();
    }

    @When("I go to Tasks module")
    public void i_go_to_Tasks_module() {
        pages.homePage().switchToModule("Tasks");
        waitForUIOverlay();
    }

    @Then("last row should contain name New Task and username for Created By and Responsible Columns")
    public void last_row_should_contain_name_New_Task_and_username_for_Created_By_and_Responsible_Columns() {
        int lastCellNumber=pages.tasksPage().getTasksColumnSize()-1;
        String expectedName=title;
        String actualName=pages.tasksPage().getTasksColumn("NAME").get(lastCellNumber);
        String expectedCreatedBy= ConfigurationReader.get("username");
        String actualCreatedBy=pages.tasksPage().getTasksColumn("CREATED BY").get(lastCellNumber);
        String expectedResponsiblePerson= ConfigurationReader.get("username");
        String actualResponsiblePerson=pages.tasksPage().getTasksColumn("RESPONSIBLE PERSON").get(lastCellNumber);
        Assert.assertEquals(expectedName, actualName);
        System.out.println(actualName);
        Assert.assertEquals(expectedCreatedBy, actualCreatedBy);
        System.out.println(actualCreatedBy);
        Assert.assertEquals(expectedResponsiblePerson, actualResponsiblePerson);
        System.out.println(actualResponsiblePerson);

    }


}
