package com.cybertek.pages;

        import com.cybertek.utilities.Driver;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

        import static com.cybertek.utilities.BrowserUtils.*;


public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "a[title='Home']")
    public WebElement home;

    @FindBy(css="span[id='user-name']")
    public WebElement userMenu;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOut;



    public void switchToModule(String module){
        Driver.get().findElement(By.linkText(module)).click();
        waitForUIOverlay();
    }

    public void logOut(){
        userMenu.click();
        logOut.click();
        waitForUIOverlay();
    }


    @FindBy(xpath = "(//span[contains(text(), 'Tasks')])")
    public WebElement myTasksTable;




}
