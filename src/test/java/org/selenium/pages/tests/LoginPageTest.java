package org.selenium.pages.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.selenim.listener.ListenerEvent;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("LogIn Page Test")
@ExtendWith(ListenerEvent.class)
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

    @Tag("fast")
    @Test
    @Epic("Allure examples №1")
    @Story("id 1")
    @DisplayName("LogIn")
    @Description("Checking LogIn page")
    @MethodSource("data")
    public void checkLogIn() {
        logInPage = new LogInPage(driver, wait);
        logInPage.loginWithData(username, password);
        String head = logInPage.getInboxText();
        assertEquals(head, "LoginTestDriver");
    }

    @Tag("fast")
    @Test
    @Epic("Allure examples №2")
    @Story("id 2")
    @DisplayName("LogOut")
    @Description("Checking LogOut page")
    @MethodSource("data")
    public void checkLogOut() {
        profilePage = new ProfilePage(driver, wait);
        profilePage.actionLogOut();
        String logText = "Log on with Yandex ID to access Yandex.Mail";
        assertEquals(logText, profilePage.getTextH1());
    }

}
