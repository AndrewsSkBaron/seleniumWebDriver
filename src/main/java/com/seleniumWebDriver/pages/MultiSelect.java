package com.seleniumWebDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiSelect {
    private WebDriver driver;
    private List<WebElement> items;
    private List<WebElement> itemsSelected;
    private WebElement button;
    private Random random;

    public MultiSelect(WebDriver driver) {
        this.driver = driver;
    }

    public MultiSelect selectRandom() {
        items = driver.findElements(By.xpath("//select[@id='multi-select']/option"));
        button = driver.findElement(By.xpath("//button[@id='printAll']"));
        Actions actions = new Actions(driver);
        getRandomElement(items, actions);
        actions.click(button).build().perform();
        return this;
    }

    public void getSelectedElement(List<WebElement> itemsSelected) {
        for(WebElement item : itemsSelected){
            System.out.println(item.getText() + " | " +  item.isSelected());
        }
    }

    public List<WebElement>  getRandomElement(List<WebElement> items, Actions actions) {
        random = new Random();
        itemsSelected = new ArrayList<>();
        int size = items.size();
        int lastLast = random.nextInt(size);
        int last = (lastLast + 1 + random.nextInt(size - 1)) % size;
        int randomNumber = (lastLast + 1 + random.nextInt(size - 2)) % size;
        for (int i = 0; i < 3; i++) {
            if (randomNumber == last) {
                randomNumber = (lastLast + size - 1) % size;
            }
            lastLast = last;
            last = randomNumber;
            actions.keyDown(Keys.CONTROL).click(items.get(randomNumber)).keyUp(Keys.CONTROL).build().perform();
            if(items.get(randomNumber).isSelected()) {
                itemsSelected.add(items.get(randomNumber));
            }
        }
        getSelectedElement(itemsSelected);
        return itemsSelected;
    }

}