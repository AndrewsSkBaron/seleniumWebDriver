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

}
