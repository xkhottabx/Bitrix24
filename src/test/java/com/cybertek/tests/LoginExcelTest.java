package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtility;
import com.cybertek.utilities.Pages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

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

    public static void main(String[] args) {
        List<String> list=new ArrayList();
        list.add("Varya");list.add("Katya");list.add("Vlad");list.add("Denzel");list.add("Timothy");
        list.forEach(varya-> System.out.println(varya));

        Map<String, Integer> map=new HashMap<>();
        map.put("Varya",1);map.put("Katya",2);map.put("Vlad",3);map.put(null,3);
        boolean key=map.containsKey("ss");
        System.out.println("key = " + key);
        map.forEach((var,va)-> {if (va%3==0)
            System.out.println(map.get(var));
        });

        int[]arr={3,6,3,5,3};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        String name="Asdfg", lastname="Dfefg";
        int age=80;

        System.out.println(name.substring(0,2)+lastname.substring(0,2)+age);

        
        

    }
}