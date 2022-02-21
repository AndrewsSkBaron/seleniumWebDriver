package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.pages.LogInPage;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LoginPageTestFireFox extends BaseTest {
    private static LogInPage loginPage;
    @Test
    public void signInEnterUser1() throws InterruptedException {
        loginPage.loginWithData("LoginTestDriver1", "test0102");
        String inboxTitle = "LoginTestDriver1";
        /*explicit wait*/
        Thread.sleep(5000);
        assertEquals(inboxTitle,loginPage.getLogInText("LoginTestDriver1"));
    }
}
