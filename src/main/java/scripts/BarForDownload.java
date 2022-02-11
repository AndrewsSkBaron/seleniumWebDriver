package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BarForDownload {
    private WebDriver driver;
    private By button = By.xpath("//button[@id='cricle-btn']");
    private FluentWait wait;

    public BarForDownload(WebDriver driver) {
        this.driver = driver;
    }

    public BarForDownload clickButton(){
        driver.findElement(button).click();
        return this;
    }

    public BarForDownload barForDownload(){
        this.clickButton();
        wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='percenttext' and text()='50%']")));
        driver.navigate().refresh();
        return new BarForDownload(driver);
    }
}
