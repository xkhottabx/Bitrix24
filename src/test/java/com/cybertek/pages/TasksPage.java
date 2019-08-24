package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TasksPage extends HomePage {
    public TasksPage() {
        super();
    }

    WebDriver driver=Driver.get();

    @FindBy(linkText = "Tasks")
    public WebElement tasks;

    @FindBy(css = "a[class='menu-item-plus-icon']")
    public WebElement createTask;

    @FindBy(css = "span[title='Upload files']")
    public WebElement uploadFiles;

    @FindBy(css = "table[class='diskuf-selector-table wd-fa-add-file-light-table']")
    public WebElement tableWithUploadFilesOptions;

    @FindBy(css = "span[title='Link']")
    public WebElement linkURL;

    @FindBy(css = "div[id='bx-admin-prefix']")
    public WebElement linkURLWindow;

    @FindBy(css = "span[class='bx-core-adm-icon-close']")
    public WebElement closeLinkURLWindow;

    @FindBy(xpath = "//span[.='Checklist']")
    public WebElement checklist;

    @FindBy(xpath = "(//span[.='add'])[2]")
    public WebElement addToChecklist;


    public void switchToNewTaskWindow(){
        driver.switchTo().frame
                (driver.findElement(By.xpath("//div[@class='side-panel side-panel-container side-panel-container-open']//iframe")));
    }

    @FindBy(xpath = "(//span[.='Task'])[2]")
    public WebElement taskOption;

    @FindBy(css = "input[data-bx-id='task-edit-title']")
    public WebElement inputTaskTitle;

    @FindBy(css = "button[id='blog-submit-button-save']")
    public WebElement buttonSendTask;

    public List<String> getTasksColumn(String columnName){
        List<WebElement> column=new ArrayList<>();
        byte numberOfColumn=0;
        switch (columnName){
            case "NAME": numberOfColumn=3; break;
            case "DEADLINE": numberOfColumn=4; break;
            case "CREATED BY": numberOfColumn=5; break;
            case "RESPONSIBLE PERSON": numberOfColumn=6; break;
        }
        column=Driver.get().findElements(By.xpath("//table[@class='main-grid-table']//td["+numberOfColumn+"]"));
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : column) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public int getTasksColumnSize(){
        return getTasksColumn("NAME").size();
    }












}
