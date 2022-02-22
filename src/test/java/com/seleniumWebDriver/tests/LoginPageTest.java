package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.pages.LogInPage;
import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlLogIn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginPageTest extends BaseTest {
    private static LogInPage loginPage;

    @Before
    public void getLogIn(String username, String password) {
        loginPage = new LogInPage(driver);
        loginPage.loginWithData(username,password);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("LoginTestDriver1", "test0102"),
                arguments("LoginTestDriver2", "test20102")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void checkLogIn(String username, String password) {
        driver.get(urlLogIn);
        getLogIn(username, password);
        String logInTitle = username;
        assertEquals(logInTitle, loginPage.getLogInText(username));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void checkLogInThread(String username, String password) throws InterruptedException {
        driver.get(urlLogIn);
        getLogIn(username, password);
        /*explicit wait*/
        Thread.sleep(5000);
        assertEquals(username, loginPage.getLogInText(username));
    }

}
