package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.cybertek.utilities.BrowserUtils.waitForTitle;
import static com.cybertek.utilities.BrowserUtils.waitForUIOverlay;


public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input[name='USER_LOGIN']")
    public WebElement username;

    @FindBy(css = "input[name='USER_PASSWORD']")
    public WebElement password;

    @FindBy(css = "input[type='submit']")
    public WebElement submit;

    public void logIn(String usernameSTR, String passwordSTR){
        username.sendKeys(usernameSTR);
        password.sendKeys(passwordSTR);
        submit.click();
        waitForUIOverlay();
    }




}










