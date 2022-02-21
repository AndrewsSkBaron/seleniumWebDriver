package org.selenium.pages.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;
import org.selenim.pages.WebDriverUtils;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BaseClass {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static LogInPage logInPage;
    protected static ProfilePage profilePage;
    protected static WebDriverUtils screenshot;
    private static String urlLogIn = "https://mail.yandex.com/";
    private static String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
    private static String gecko = "webdriver.gecko.driver";
    private static String username = "LoginTestDriver1";
    private static String password = "test0102";

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("LoginTestDriver1", "test0102")
        );
    }

    @BeforeAll
    @MethodSource("data")
    public static void setUp(){
        System.setProperty(gecko, path);
        driver = new FirefoxDriver();
        screenshot = new WebDriverUtils();
        logInPage = LogInPage.getLogInPage(driver);
        profilePage = ProfilePage.getProfilePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(urlLogIn);
        logInPage.loginWithData(username, password);
        wait = new WebDriverWait(driver,10);
        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='user-account__name']")));
        screenshot.makeScreen(driver);
        profilePage.actionLogOut();
        screenshot.makeScreen(driver);
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("<----- | Browser Session End | ----->");
    }
}
