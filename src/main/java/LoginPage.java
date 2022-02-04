import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driverFireFox;

    private By loginField = By.xpath("//input[@id='passp-field-login']");

    private By passwordField = By.xpath("//input[@id='passp-field-passwd']");
    private By signInButtonOnHome = By.xpath("//a[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']");

    private By signInButton = By.xpath(" //button[@id='passp:sign-in']");
    private By heading = By.xpath("//h1[contains(@class,'passp-title')]//span");

    private By inbox = By.xpath("//span[normalize-space()='Inbox']");
    private By errorLogin= By.xpath("//div[@id='field:input-login:hint']");

    private By errorPassword = By.xpath("//div[@id='field:input-passwd:hint']");

    public LoginPage(WebDriver driver) {
        this.driverFireFox = driver;
    }

    public LoginPage clickButton(){
        driverFireFox.findElement(signInButtonOnHome).click();
        return this;
    }

    public LoginPage typeUsername(String username){
        driverFireFox.findElement(loginField).sendKeys(username);
        driverFireFox.findElement(signInButton).click();
        return this;
    }

    public LoginPage typePassword(String password){
        driverFireFox.findElement(passwordField).sendKeys(password);
        driverFireFox.findElement(signInButton).submit();
        return this;
    }

    public LoginPage loginWithdData(String username, String password){
        this.clickButton();
        this.typeUsername(username);
        this.typePassword(password);
        return new LoginPage(driverFireFox);
    }


    public String getInboxText(){
        return driverFireFox.findElement(inbox).getText();
    }

    public String getHeadingText(){
        return driverFireFox.findElement(heading).getText();
    }

    public String getErrorLoginText(){
        return driverFireFox.findElement(errorLogin).getText();
    }

    public String getErrorPasswordText(){
        return driverFireFox.findElement(errorPassword).getText();
    }


}