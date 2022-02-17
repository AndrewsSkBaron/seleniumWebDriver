package com.seleniumWebDriver.scripts;

import com.seleniumWebDriver.ojb.ObjectOfEmployees;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableScript {
    private WebDriver driver;
    private List<ObjectOfEmployees> employees = new ArrayList<>();
    private By countPages = By.xpath("//div[@id='example_paginate']//span//a");
    private By pageActive = By.xpath("//div[@id='example_paginate']//span//a[@class='paginate_button current']");
    private By rows = By.xpath("//table[@id='example']//tbody//tr");

    public TableScript(WebDriver driver) {
        this.driver = driver;
    }

    public TableScript rowSelection(int x, int y) {
        Integer pages = driver.findElements(countPages).size();
        for(int i = 1; i <= pages; i++) {
            WebElement activeP = driver.findElement(pageActive);
            activeP.click();
            getRows(x,y);
            String page = Integer.toString(i + 1 );
            try{
                driver.findElement(By.xpath("//div[@id='example_paginate']//span//a[text()='"+ page +"']")).click();
            }catch (NoSuchElementException e){
                Thread.interrupted();
            }
        }
        return this;
    }

    public Object getRows(int x, int y) {
        for(WebElement row : driver.findElements(rows)) {
            String age = row.findElement(By.xpath(".//td[4]")).getText();
            String salary = row.findElement(By.xpath(".//td[6]")).getText();
            String salarySub = salary.substring(salary.indexOf("$") + 1, salary.indexOf("/y"));
            int ageNum = Integer.valueOf(age);
            Integer salaryNum = Integer.valueOf(salarySub.replaceAll(",", ""));
            String name = row.findElement(By.xpath(".//td[1]")).getText();
            String position = row.findElement(By.xpath(".//td[2]")).getText();
            String office = row.findElement(By.xpath(".//td[3]")).getText();
            if(ageNum > x && salaryNum <= y){
                listOfEmployees(name,position,office);
            }
        }
        return this;
    }

    public List<ObjectOfEmployees> listOfEmployees(String name,String position,String office) {
        ObjectOfEmployees objectOfEmployees = new ObjectOfEmployees(name, position, office);
        employees.add(objectOfEmployees);
        return employees;
    }
}
