import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scripts.BarForDownload;
import scripts.ForTable;
import scripts.WaitForUser;

import java.time.Duration;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);

        driver = new FirefoxDriver();
        /* Implicitly Wait */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        /*explicit wait*/
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='LogintTestDriver']")));
        System.out.println(firstResult.getText());
        driver.get("https://mail.yandex.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithdData("LogintTestDriver", "test0102");

        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
        WaitForUser script1 = new WaitForUser(driver);
        script1.scriptWaitForUser();
        driver.quit();

        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        BarForDownload script2 = new BarForDownload(driver);
        script2.barForDownload();
        driver.quit();

        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        ForTable table = new ForTable(driver);
        table.rowSelection(33, 125000);
        driver.quit();

    }
}
