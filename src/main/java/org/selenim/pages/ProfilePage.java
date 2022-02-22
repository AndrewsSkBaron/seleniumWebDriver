package org.selenim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProfilePage {
    /*Page Object*/
    private WebDriver driver;
    private WebDriverWait wait;
    private By userIcon = By.xpath("//div[@class='legouser legouser_fetch-accounts_yes legouser_hidden_yes i-bem']/a[1]");
    private By logOutLink = By.xpath("//a[@aria-label='Log out']");
    private By logOutLinkText = By.xpath("//a[@aria-label='Log out']/span");
    private By h1 = By.xpath("//h1[@class='passp-title ']");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public ProfilePage clickUserIcon(){
        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='user-account__name']")));
        driver.findElement(userIcon).click();
        return this;
    }

    public String getTextLogOut(){
        return driver.findElement(logOutLinkText).getText();
    }

    public String getTextH1(){
        return driver.findElement(h1).getText();
    }

    public ProfilePage clickLogOutLink(){
        driver.findElement(logOutLink).click();
        return this;
    }

    public ProfilePage actionLogOut(){
        this.clickUserIcon();
        this.getTextLogOut();
        this.clickLogOutLink();
        return this;
    }

}
