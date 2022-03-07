package org.selenim.listener;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenim.driver.Driver;

import java.io.ByteArrayInputStream;

public class ListenerEvent implements TestWatcher {
    WebDriver driver = Driver.getInstance();
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("LogIn page", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        Allure.addAttachment("Name of a browser", new FirefoxDriver().toString());
    }
}
