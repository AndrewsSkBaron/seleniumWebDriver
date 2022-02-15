import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5000,
                TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");

        LogInPage logInPage = LogInPage.getLogInPage(driver);
        logInPage.loginWithData("LoginTestDriver2", "test20102");
        ProfilePage profilePage = ProfilePage.getProfilePage(driver);
        profilePage.actionLogOut();

        driver.quit();
    }
}
