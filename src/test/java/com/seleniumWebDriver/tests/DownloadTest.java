package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.script.Download;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlDownload;
import static org.junit.Assert.assertTrue;

public class DownloadTest extends BaseTest {
    private Download download;
    private By item = By.xpath("//input[@id='cricleinput']");

    @Test
    public void checkSelectRandom() {
        driver.get(urlDownload);
        download = new Download(driver);
        WebElement element = driver.findElement(item);
        int num = Integer.parseInt(element.getAttribute("value"));
        download.download();
        assertTrue(num == 0);
    }
}
