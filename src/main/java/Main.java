import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithdData("LogintTestDriver", "test0102");
    }
}
