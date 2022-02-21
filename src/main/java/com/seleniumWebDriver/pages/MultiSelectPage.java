package com.seleniumWebDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class MultiSelectPage {
    private WebDriver driver;
    private By selectBy = By.xpath("//select[@id='multi-select']");
    private By buttonBy = By.xpath("//button[@id='printAll']");
    private Select select;
    private WebElement button;
    private List<WebElement> itemsSelected;
    private Random random = new Random();

    public MultiSelectPage(WebDriver driver) {
        this.driver = driver;
    }

    public MultiSelectPage getRandomElement() {
        select = new Select(driver.findElement(selectBy));
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
            select.selectByIndex(randomNumber);
        }
        if(select.isMultiple()) {
            button.click();
        }
        return this;
    }

    public List<WebElement> getSelectedElement() {
        itemsSelected = select.getAllSelectedOptions();
        return itemsSelected;
    }
}
