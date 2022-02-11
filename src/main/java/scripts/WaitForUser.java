package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitForUser {
    private WebDriver driver;
    private By button = By.xpath("//button[@id='save']");
    private Wait<WebDriver> wait;

    public WaitForUser(WebDriver driver) {
        this.driver = driver;
    }

    public WaitForUser clickButton(){
        driver.findElement(button).click();
        return this;
    }
    public WaitForUser waitForUser(){
        wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='loading']/*")));
        return this;
    }

    public WaitForUser scriptWaitForUser(){
        this.clickButton();
        this.waitForUser();
        return new WaitForUser(driver);
    }

}
