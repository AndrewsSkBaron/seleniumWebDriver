package org.selenim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    /*Page Factory*/
    private static LogInPage logInPage;
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='HeadBanner-ButtonsWrapper']/a[2]")
    private WebElement signInButtonOnHome;

    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement signInButton;

    @FindBy(xpath = "//h1[contains(@class,'passp-title')]//span")
    private WebElement heading;

    @FindBy(xpath = "//span[normalize-space()='LoginTestDriver2']")
    private WebElement logInTitle;

    @FindBy(xpath = "//div[@id='field:input-login:hint']")
    private WebElement errorLogin;

    @FindBy(xpath = "//div[@id='field:input-passwd:hint']")
    private WebElement errorPassword;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogInPage clickButton(){
        signInButtonOnHome.click();
        return this;
    }

    public LogInPage typeUsername(String username){
        loginField.sendKeys(username);
        signInButton.click();
        return this;
    }

    public LogInPage typePassword(String password){
        passwordField.sendKeys(password);
        signInButton.submit();
        return this;
    }


    public String getInboxText(){
        return logInTitle.getText();
    }

    public static LogInPage getLogInPage(WebDriver driver) {
        if (logInPage == null) {
            logInPage = PageFactory.initElements(driver, LogInPage.class);
        }
        return logInPage;
    }

    public LogInPage loginWithData(String username, String password){
        this.clickButton();
        this.typeUsername(username);
        this.typePassword(password);
        return this;
    }

    public String getHeadingText(){
        return heading.getText();
    }

    public String getErrorLoginText(){
        return errorLogin.getText();
    }

    public String getErrorPasswordText(){
        return errorPassword.getText();
    }


}