package com.seleniumWebDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiSelectPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By selectBy = By.xpath("//select[@id='multi-select']");
    private By buttonBy = By.xpath("//button[@id='printAll']");
    private By detailSelected = By.xpath("//p[@class='getall-selected']");
    private Select select;
    private Actions builder;
    private WebElement button;
    private List<WebElement> itemsSelected;
    private Random random = new Random();


    public MultiSelectPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public MultiSelectPage getRandomElement() {
        builder = new Actions(driver);
        select = new Select(getSelectBy());
        button = driver.findElement(buttonBy);
        int size = select.getOptions().size();
        int lastLast = random.nextInt(size);
        int last = (lastLast + 1 + random.nextInt(size - 1)) % size;
        int randomNumber = (lastLast + 1 + random.nextInt(size - 2)) % size;
        for (int i = 0; i < 3; i++) {
            if (randomNumber == last) {
                randomNumber = (lastLast + size - 1) % size;
            }
            lastLast = last;
            last = randomNumber;
            builder.keyDown(Keys.CONTROL).moveToElement(select.getOptions().get(randomNumber)).click();
            builder.perform();
        }
        button.click();
        return this;
    }

    public WebElement getSelectBy() {
        return driver.findElement(selectBy);
    }

    public List<String> getSelectedElement() {
        List<String> result = new ArrayList<>();
        itemsSelected = select.getAllSelectedOptions();
        for (WebElement item : itemsSelected) {
            result.add(item.getText());
        }
        System.out.println(result.toString());
        return result;
    }

    public List<String> getDetailSelected() {
        List<String> detailResult = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(detailSelected));
        String detail = driver.findElement(detailSelected).getText();
        String detailSub = detail.substring(detail.indexOf(":") + 2).replaceAll(",", ", ");
        detailResult.add(detailSub);
        return detailResult;
    }
}
