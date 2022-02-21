package com.seleniumWebDriver.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public Alert alertElement() {
        wait = new WebDriverWait(driver, 5);
        alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public String confirmBoxAccept() {
        driver.findElement(buttonBoxAccept).click();
        text = alertElement().getText();
        alertElement().accept();
        return text;
    }

    public String confirmBoxDismiss() {
        driver.findElement(buttonBoxDismiss).click();
        text = alertElement().getText();
        alertElement().dismiss();
        return text;
    }

    public String confirmAlertAccept() {
        driver.findElement(buttonAlertAccept).click();
        alertElement().sendKeys("Click click!!!");
        text = alertElement().getText();
        alertElement().dismiss();
        return text;
    }

}
