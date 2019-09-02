package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtility;
import com.cybertek.utilities.Pages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginExcelTest {
SoftAssert softAssert=new SoftAssert();
    @Test
    public void test() {
         Pages pages=new Pages();
        ExcelUtility qa3Sheet = new ExcelUtility("src/test/resources/credentials.xlsx", "LoginPassword");
        Driver.get().get(ConfigurationReader.get("url"));
        for (int i = 0; i <qa3Sheet.rowCount(); i++) {
            pages.loginPage().logIn(qa3Sheet.getCellData(i, 0), qa3Sheet.getCellData(i, 1));
            softAssert.assertEquals(Driver.get().getTitle(), "Portal");
            pages.homePage().logOut();
            pages.loginPage().username.clear();
        }
        Driver.closeDriver();
        softAssert.assertAll();
    }
}