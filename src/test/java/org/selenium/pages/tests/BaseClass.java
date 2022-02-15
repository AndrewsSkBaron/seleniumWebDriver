package org.selenium.pages.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public abstract class BaseClass {
    protected static WebDriver driver;
    protected static LogInPage logInPage;
    protected static ProfilePage profilePage;
    private static String urlLogIn = "https://mail.yandex.com/";
    private static String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
    private static String gecko = "webdriver.gecko.driver";
    private static String username = "LoginTestDriver2";
    private static String password = "test20102";

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("LoginTestDriver2", "test20102")
        );
    }

    @BeforeAll
    @MethodSource("data")
    public static void setUp(){
        System.setProperty(gecko, path);
        driver = new FirefoxDriver();
        logInPage = LogInPage.getLogInPage(driver);
        profilePage = ProfilePage.getProfilePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(urlLogIn);
        logInPage.loginWithData(username, password);
        profilePage.actionLogOut();
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("<----- | Browser Session End | ----->");
    }
}
