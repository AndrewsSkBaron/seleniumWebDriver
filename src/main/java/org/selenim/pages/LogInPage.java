package org.selenim.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage {

    /*Page Factory*/
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


    /*Page Object*/
    private WebDriver driver;
    private WebDriverWait wait;

    private By signInButtonOnHome = By.xpath("//div[@class='HeadBanner-ButtonsWrapper']/a[2]");
    private By loginField = By.xpath("//input[@id='passp-field-login']");
    private By passwordField = By.xpath("//input[@id='passp-field-passwd']");
    private By signInButton = By.xpath(" //button[@id='passp:sign-in']");
    private By heading = By.xpath("//h1[contains(@class,'passp-title')]//span");
    private By logInTitle = By.xpath("//span[normalize-space()='LoginTestDriver1']");
    private By errorLogin= By.xpath("//div[@id='field:input-login:hint']");
    private By errorPassword = By.xpath("//div[@id='field:input-passwd:hint']");


    public LogInPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

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
        return driver.findElement(logInTitle).getText();
    }

    public LogInPage loginWithData(String username, String password){
        this.clickButton();
        this.typeUsername(username);
        this.typePassword(password);
        wait.until(visibilityOfElementLocated(logInTitle));
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