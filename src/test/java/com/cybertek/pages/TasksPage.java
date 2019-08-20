package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage extends HomePage {
    public TasksPage() {
        super();
    }

    @FindBy(linkText = "Tasks")
    public WebElement tasks;

    @FindBy(css = "a[class='menu-item-plus-icon']")
    public WebElement createTask;

    @FindBy(css = "span[title='Upload files']")
    public WebElement uploadFiles;

    @FindBy(css = "table[class='diskuf-selector-table wd-fa-add-file-light-table']")
    public WebElement tableWithUploadFilesOptions;



}
