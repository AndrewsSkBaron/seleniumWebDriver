import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
public class MultiSelectTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    @Test
    public void selectRandom() {
        WebElement button = driver.findElement(By.xpath("//button[@id='printMe']"));
        List<WebElement> items = driver.findElements(By.xpath("//select[@id='multi-select']/option"));
        WebElement element = driver.findElement(By.xpath("//select[@id='multi-select']/option"));
        Actions builder = new Actions(driver);
        int size = items.size();
        Random random = new Random();
        int lastLast = random.nextInt(size);
        int last = (lastLast + 1 + random.nextInt(size - 1)) % size;
        for (int i = 0; i < 3; i++) {
            int randomNumber = (lastLast + 1 + random.nextInt(size - 2)) % size;
            if (randomNumber == last) {
                randomNumber = (lastLast + size - 1) % size;
            }
            lastLast = last;
            last = randomNumber;
            builder.moveToElement(element).click(element);
            builder.perform();
            items.get(randomNumber).click();
            if (items.get(randomNumber).isSelected()) {
                System.out.println(items.get(randomNumber).getText());
                button.click();
            }
            assertEquals(true, items.get(randomNumber).isSelected());
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
