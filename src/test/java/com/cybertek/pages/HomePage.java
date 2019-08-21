package com.cybertek.pages;

        import com.cybertek.utilities.Driver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;


public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "a[title='Home']")
    public WebElement home;

    @FindBy(xpath = "(//span[contains(text(), 'Activity Stream')])[1]")
    public WebElement activityStream;

    @FindBy(xpath = "(//span[contains(text(), 'Tasks')])")
    public WebElement tasks;

    @FindBy(xpath = "(//span[contains(text(), 'Tasks')])")
    public WebElement myTasksTable;

   // (//table[@class='main-grid-table'])[1]









}
