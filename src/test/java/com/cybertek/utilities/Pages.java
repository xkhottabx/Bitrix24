package com.cybertek.utilities;

import com.cybertek.pages.HomePage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.TasksPage;

public class Pages {
    private LoginPage loginPage;
    private HomePage homePage;
    private TasksPage tasksPage;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public TasksPage tasksPage() {
        if (tasksPage == null) {
            tasksPage = new TasksPage();
        }
        return tasksPage;
    }
}
