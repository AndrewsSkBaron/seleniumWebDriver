import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driverFireFox;
    static WebDriver driverGoogleChrome;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\AndreiBaron\\IdeaProjects\\seleniumWebDriver\\src\\main\\resources\\drivers\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AndreiBaron\\IdeaProjects\\seleniumWebDriver\\src\\main\\resources\\drivers\\chromedriver\\chromedriver.exe");

        driverFireFox = new FirefoxDriver();
        driverFireFox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverFireFox.manage().window().maximize();
        driverFireFox.get("https://mail.yandex.com/");

        LoginPage loginPageFireFox = new LoginPage(driverFireFox);
        loginPageFireFox.loginWithdData("LogintTestDriver", "test0102");

        driverGoogleChrome = new ChromeDriver();
        driverGoogleChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverGoogleChrome.manage().window().maximize();
        driverGoogleChrome.get("https://mail.yandex.com/");

        LoginPage loginPageGoogleChrome = new LoginPage(driverGoogleChrome);
        loginPageGoogleChrome.loginWithdData("LogintTestDriver", "test0102");
    }
}
