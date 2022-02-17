package pagesTests;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LoginPageTestFireFox extends BaseClass {
    @Test
    public void signInEnterUser1() throws InterruptedException {
        loginPage.loginWithData("LoginTestDriver1", "test0102");
        String inboxTitle = "LoginTestDriver1";
        /*explicit wait*/
        Thread.sleep(5000);
        assertEquals(inboxTitle,loginPage.getLogInText());
    }
}
