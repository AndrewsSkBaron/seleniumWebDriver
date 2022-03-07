package org.selenim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProfilePage {

    /*Page Object*/
    private WebDriver driver;
    private WebDriverWait wait;
    private By userIcon = By.xpath("//div[@class='legouser legouser_fetch-accounts_yes legouser_hidden_yes i-bem']/a[1]");
    private By logOutLink = By.xpath("//a[@aria-label='Log out']");
    private By logOutLinkText = By.xpath("//a[@aria-label='Log out']/span");
    private By h1 = By.xpath("//div[@class='HeadBanner-Title']");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    /*Page Factory*/

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='legouser legouser_fetch-accounts_yes legouser_hidden_yes i-bem']/a[1]")
    private WebElement userIcon;


    @FindBy(xpath = "//a[@aria-label='Log out']")
    private WebElement logOutLink;

    @FindBy(xpath = "//a[@aria-label='Log out']/span")
    private WebElement logOutLinkText;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    public ProfilePage clickUserIcon(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='user-account__name']")));
        userIcon.click();
        return this;
    }

    public String getTextLogOut(){
        return logOutLinkText.getText();
    }

    public String getTextH1(){
        return driver.findElement(h1).getText();
    }

    public ProfilePage clickLogOutLink(){
        logOutLink.click();
        return this;
    }

    public ProfilePage actionLogOut(){
        this.clickUserIcon();
        this.getTextLogOut();
        this.clickLogOutLink();
        return this;
    }

}
