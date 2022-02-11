import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class AlertTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
    }

    @Test
    public void javaScriptConfirmBoxAccept() {
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][normalize-space()='Click me!']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        assertEquals("Press a button!", text);
    }

    @Test
    public void javaScriptConfirmBoxDismiss() {
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][normalize-space()='Click me!']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.dismiss();
        assertEquals("Press a button!", text);
    }

    @Test
    public void javaScriptAlertBoxAccept() {
        driver.findElement(By.xpath("//button[normalize-space()='Click for Prompt Box']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.sendKeys("Click click!!!");
        String text = alert.getText();
        alert.accept();
        assertEquals("Please enter your name", text);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
