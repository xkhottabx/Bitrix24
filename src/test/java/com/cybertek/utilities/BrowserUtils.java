package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserUtils {


    public static Boolean waitForTitle(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitForUIOverlay() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader-mask.shown")));
    }

    public static boolean loginVerification(String user){
        return Driver.get().findElement(By.xpath("//span[.='"+user+"']")).isDisplayed();
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
