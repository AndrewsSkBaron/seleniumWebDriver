import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginPageTestFireFox {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
    }

    @Test
    public void signInEnterUser1() {
        loginPage.loginWithdData("LogintTestDriver", "test0102");
        String head = loginPage.getInboxText();
        String inboxTitle = "Inbox";

        /*explicit wait*/
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
        }

        assertEquals(head, inboxTitle);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}