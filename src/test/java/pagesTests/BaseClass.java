package pagesTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.seleniumWebDriver.pages.LogInPage;

import java.time.Duration;

public abstract class BaseClass {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static LogInPage loginPage;
    protected static String urlLogIn = "https://mail.yandex.com/";
    protected static String urlMultiSelect = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    protected static String urlAlert = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private static String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
    private static String gecko = "webdriver.gecko.driver";

    @BeforeEach
    public void setUp(){
        System.setProperty(gecko, path);
        driver = new FirefoxDriver();
        loginPage = new LogInPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("<----- | Browser Session End | ----->");
        driver.quit();
    }

}
