import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
    }

    public static Stream<Arguments> signIn() {
        return Stream.of(
                arguments("LogintTestDriver", "test0102"),
                arguments("LoginTestDriver2", "test20102")
        );
    }

    @ParameterizedTest
    @MethodSource("signIn")
    public void signInEnterUser1(String username, String password){
        loginPage.loginWithdData(username,password);
        String head = loginPage.getInboxText();
        String inboxTitle = "Inbox";

        /*explicit wait*/
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+ username +"']")));
        System.out.println(firstResult.getText());
        System.out.println(loginPage.getInboxText());

        assertEquals(head, inboxTitle);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
