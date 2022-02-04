import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ByElement {
    private WebDriver driver;
    private By createAccountButtonHomeCss = By.cssSelector(".button2_type_link");
    private By signInButtonHomeClass = By.className("button2_theme_mail-white");
    private By linkText = By.linkText("I forgot");
    private By buttonCreateID = By.id("passp:exp-register");
    private By inputLogin = By.name("login");
    private By linkLearnMore = By.partialLinkText("Learn");
    private By tagName = By.tagName("h2");
    private By form = By.xpath("//form[@method='post']");

    public ByElement(WebDriver driver) {
        this.driver = driver;
    }

    public ByElement buttonHomeCss() {
        driver.findElement(createAccountButtonHomeCss);
        System.out.println(driver.findElement(createAccountButtonHomeCss).getText());
        return this;
    }

    public ByElement signInButtonHomeClass() {
        driver.findElement(signInButtonHomeClass);
        System.out.println(driver.findElement(signInButtonHomeClass).getText());
        driver.findElement(signInButtonHomeClass).click();
        return this;
    }

    public ByElement linkText() {
        driver.findElement(linkText);
        System.out.println(driver.findElement(linkText).getText());
        return this;
    }

    public ByElement buttonCreateID() {
        driver.findElement(buttonCreateID);
        System.out.println(driver.findElement(buttonCreateID).getText());
        return this;
    }

    public ByElement inputLogin() {
        driver.findElement(inputLogin);
        System.out.println(driver.findElement(inputLogin).getTagName());
        return this;
    }

    public ByElement linkLearnMore() {
        driver.findElement(linkLearnMore);
        System.out.println(driver.findElement(linkLearnMore).getText());
        return this;
    }

    public ByElement getTagName() {
        driver.findElement(tagName);
        System.out.println(driver.findElement(tagName).getTagName());
        return this;
    }

    public ByElement getForm() {
        driver.findElement(form);
        System.out.println(driver.findElement(form).getTagName());
        return this;
    }

    public void startFinding() {
        buttonHomeCss();
        signInButtonHomeClass();
        linkText();
        buttonCreateID();
        inputLogin();
        linkLearnMore();
        getTagName();
        getForm();
    }
}
