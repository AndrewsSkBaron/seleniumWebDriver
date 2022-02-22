package org.selenium.pages.tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.provider.Arguments;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class LoginPageTest extends BaseTest {
    private static LogInPage logInPage;
    private static ProfilePage profilePage;
    private static String username = "LoginTestDriver1";
    private static String password = "test0102";

    public static Stream<Arguments> data() {
        return Stream.of(
            arguments("LoginTestDriver1", "test0102")
        );
    }

    @Order(1)
    @Test
    public void checkLogIn() {
        logInPage = new LogInPage(driver,wait);
        logInPage.loginWithData(username, password);
        String head = logInPage.getInboxText();
        assertEquals(head, username);
        screenshot.makeScreen(driver);
    }

    @Order(2)
    @Test
    public void checkLogOut() {
        profilePage = new ProfilePage(driver, wait);
        profilePage.actionLogOut();
        String logText = "Log in with Yandex ID to access Yandex.Mail";
        assertEquals(logText, profilePage.getTextH1());
        screenshot.makeScreen(driver);
    }
}
