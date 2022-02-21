package org.selenim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProfilePage {
    /*Page Object*/
    private WebDriver driver;

    private By userIcon = By.xpath("//div[@class='legouser legouser_fetch-accounts_yes legouser_hidden_yes i-bem']/a[1]");
    private By logOutLink = By.xpath("//a[@aria-label='Log out']");
    private By logOutLinkText = By.xpath("//a[@aria-label='Log out']/span");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage clickUserIcon(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='user-account__name']")));
        driver.findElement(userIcon).click();
        return this;
    }

    public String getTextLogOut(){
        return driver.findElement(logOutLinkText).getText();
    }

    public ProfilePage clickLogOutLink(){
        driver.findElement(logOutLink).click();
        return this;
    }

    public ProfilePage actionLogOut(){
        this.clickUserIcon();
        this.getTextLogOut();
        this.clickLogOutLink();
        return new ProfilePage(driver);
    }

}
