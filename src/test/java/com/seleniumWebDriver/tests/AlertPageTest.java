package com.seleniumWebDriver.tests;

import org.junit.jupiter.api.Test;
import com.seleniumWebDriver.pages.AlertPage;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlAlert;
import static org.junit.Assert.assertEquals;

public class AlertPageTest extends BaseTest {
    private AlertPage alertPage;

    @Test
    public void checkBoxAccept() {
        driver.get(urlAlert);
        alertPage = new AlertPage(driver);
        assertEquals("I am an alert box!", alertPage.confirmBoxAccept());
    }

    @Test
    public void checkBoxDismiss() {
        driver.get(urlAlert);
        alertPage = new AlertPage(driver);
        alertPage.confirmBoxAccept();
        assertEquals("Press a button!", alertPage.confirmBoxDismiss());
    }

    @Test
    public void checkAlertAccept() {
        driver.get(urlAlert);
        alertPage = new AlertPage(driver);
        alertPage.confirmAlertAccept();
        assertEquals("Please enter your name", alertPage.confirmAlertAccept());
    }
}
