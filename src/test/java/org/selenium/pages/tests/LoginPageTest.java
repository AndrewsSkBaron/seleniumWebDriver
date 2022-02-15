package org.selenium.pages.tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class LoginPageTest extends BaseClass {
    @Order(1)
    @Test
    public void checkLogIn(){
        String head = logInPage.getInboxText();
        String inboxTitle = "LoginTestDriver2";
        assertEquals(head, inboxTitle);
    }

    @Order(2)
    @Test
    public void checkLogOut(){
        String logOutTitle = driver.findElement(By.xpath("//h1[@class='passp-title ']")).getText();
        String logText = "Log in with Yandex ID to access Yandex.Mail";
        assertEquals(logText, logOutTitle);
    }
}
