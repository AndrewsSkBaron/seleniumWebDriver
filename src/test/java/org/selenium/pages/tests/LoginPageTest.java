package org.selenium.pages.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.selenim.listener.ListenerEvent;
import org.openqa.selenium.By;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("LogIn Page Test")

public class LoginPageTest extends BaseTest {
    private static LogInPage logInPage;
    private static ProfilePage profilePage;
    private static String username = "LoginTestDriver3";
    private static String password = "test0102";

    public static Stream<Arguments> data() {
        return Stream.of(
            arguments("LoginTestDriver1", "test0102")
    private LogInPage logInPage;
    private ProfilePage profilePage;
    private String username = "LoginTestDriver2";
    private String password = "test20102";

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("LoginTestDriver2", "test20102")

    private LogInPage logInPage;
    private ProfilePage profilePage;
    private String username = "LoginTestDriver1";
    private String password = "test0102";

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
        assertEquals(head, username);
        screenshot.makeScreen(driver);
    public void checkLogIn(){
        logInPage = new LogInPage(driver);
        logInPage.loginWithData(username, password);
        String head = logInPage.getInboxText();
        String inboxTitle = "LoginTestDriver1";
        assertEquals(head, inboxTitle);
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
    public void checkLogOut(){
        profilePage = new ProfilePage(driver);
        String logOutTitle = driver.findElement(By.xpath("//h1[@class='passp-title ']")).getText();
        profilePage.actionLogOut();
        String logText = "Sincerely yours,\n" +
                "Yandex.Mail";
        assertEquals(logText, profilePage.getTextH1());
    }

}
