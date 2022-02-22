import com.seleniumWebDriver.pages.TablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        String gecko = "webdriver.gecko.driver";
        String urlTable = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
        System.setProperty(gecko, path);
        WebDriver driver = new FirefoxDriver();
        driver.get(urlTable);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TablePage tablePage = new TablePage(driver);
        tablePage.rowSelection(33, 120000);
        System.out.println(tablePage.getEmployees(33, 120000));
    }
}
