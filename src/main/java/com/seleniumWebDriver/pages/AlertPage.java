package com.seleniumWebDriver.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By buttonBoxAccept = By.xpath("//button[@class='btn btn-default']");
    private By buttonBoxDismiss = By.xpath("//button[@class='btn btn-default btn-lg'][normalize-space()='Click me!']");
    private By buttonAlertAccept = By.xpath("//button[normalize-space()='Click for Prompt Box']");
    private Alert alert;
    private String text;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public String confirmBoxAccept() {
        driver.findElement(buttonBoxAccept).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        text = alert.getText();
        alert.accept();
        return text;
    }

    public String confirmBoxDismiss() {
        driver.findElement(buttonBoxDismiss).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        text = alert.getText();
        alert.dismiss();
        return text;
    }

    public String confirmAlertAccept() {
        driver.findElement(buttonAlertAccept).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Click click!!!");
        text = alert.getText();
        alert.dismiss();
        return text;
    }

}
