package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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






}
