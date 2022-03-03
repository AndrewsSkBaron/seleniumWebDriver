package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.pages.DownloadPage;
import org.junit.jupiter.api.Test;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlDownload;
import static org.junit.Assert.assertTrue;

public class DownloadTest extends BaseTest {
    private DownloadPage download;
    private int num;

    @Test
    public void checkSelectRandom() {
        driver.get(urlDownload);
        download = new DownloadPage(driver, wait);
        download.refresh();
        num = Integer.parseInt(download.refresh().getAttribute("value"));
        assertTrue(num == 0);
    }
}
