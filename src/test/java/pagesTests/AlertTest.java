package pagesTests;

import org.junit.jupiter.api.Test;
import com.seleniumWebDriver.pages.AlertPage;

import static org.junit.Assert.assertEquals;

public class AlertTest extends BaseClass {
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
