package org.selenium.pages.tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
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

    @Order(1)
    @Test
    public void checkLogIn() {
        logInPage = new LogInPage(driver,wait);
        logInPage.loginWithData(username, password);
        String head = logInPage.getInboxText();
        assertEquals(head, username);
        screenshot.makeScreen(driver);
    public void checkLogIn(){
        logInPage = new LogInPage(driver);
        logInPage.loginWithData(username, password);
        String head = logInPage.getInboxText();
        String inboxTitle = "LoginTestDriver1";
        assertEquals(head, inboxTitle);
    }

    @Order(2)
    @Test
    public void checkLogOut() {
        profilePage = new ProfilePage(driver, wait);
    public void checkLogOut(){
        profilePage = new ProfilePage(driver);
        String logOutTitle = driver.findElement(By.xpath("//h1[@class='passp-title ']")).getText();
        profilePage.actionLogOut();
        String logText = "Log in with Yandex ID to access Yandex.Mail";
        assertEquals(logText, profilePage.getTextH1());
        screenshot.makeScreen(driver);
    }
}
