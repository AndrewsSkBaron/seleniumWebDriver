import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginPageTestGoogleChrome {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AndreiBaron\\IdeaProjects\\seleniumWebDriver\\src\\main\\resources\\drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void signIn() {
        loginPage.clickButton();
        String head = loginPage.getHeadingText();
        String expectedTitle = "Log in with Yandex ID to access Yandex.Mail";
        assertEquals(head, expectedTitle);
    }

    @Test
    public void signInEnter() {
        loginPage.loginWithdData("LogintTestDriver", "test0102");
        String head = loginPage.getInboxText();
        String inboxTitle = "Inbox";
        assertEquals(head, inboxTitle);
    }

    @Test
    public void signInEnterEmptyUsername() {
        loginPage.clickButton();
        loginPage.typeUsername("");
        String error = loginPage.getErrorLoginText();
        assertEquals("Enter a login", error);
    }

    @Test
    public void signInEnterEmptyPassword() {
        loginPage.clickButton();
        loginPage.typeUsername("LogintTestDriver");
        loginPage.typePassword("");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='field:input-passwd:hint']")));
        String error = loginPage.getErrorPasswordText();
        assertEquals("Enter password", error);
    }

    @Test
    public void signInEnterErrorUsername() {
        loginPage.clickButton();
        loginPage.typeUsername("LoginTestDriver");
        String error = loginPage.getErrorLoginText();
        assertEquals("Account doesn't exist", error);
    }

    @Test
    public void signInEnterErrorPassword() {
        loginPage.clickButton();
        loginPage.typeUsername("LogintTestDriver");
        loginPage.typePassword("test0101");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='field:input-passwd:hint']")));
        String error = loginPage.getErrorPasswordText();
        assertEquals("Incorrect password", error);
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
