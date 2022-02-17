package pagesTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginPageTest extends BaseClass{

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("LoginTestDriver1", "test0102"),
                arguments("LoginTestDriver2", "test20102")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void checkLogIn(String username, String password){
        driver.get(urlLogIn);
        loginPage.loginWithData(username,password);
        String logInTitle = username;
        /*explicit wait*/
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+ username +"']")));
        assertEquals(logInTitle,firstResult.getText());
    }

    @ParameterizedTest
    @MethodSource("data")
    public void checkLogInThread(String username, String password) throws InterruptedException {
        driver.get(urlLogIn);
        loginPage.loginWithData(username,password);
        /*explicit wait*/
        String logInTitle = username;
        Thread.sleep(5000);
        assertEquals(logInTitle,loginPage.getLogInText());
    }

}
