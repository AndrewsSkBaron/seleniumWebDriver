package com.seleniumWebDriver.pages;

import com.seleniumWebDriver.ojb.Employees;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    private WebDriver driver;
    private List<Employees> employees = new ArrayList<>();
    private By countPages = By.xpath("//div[@id='example_paginate']//span//a");
    private By rows = By.xpath("//table[@id='example']//tbody//tr");

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public TablePage rowSelection(int age, int salary) {
        Integer pages = driver.findElements(countPages).size();
        for (int i = 1; i <= pages; i++) {
            String page = Integer.toString(i);
            getEmployees(age, salary);
            driver.findElement(By.xpath("//a[@id='example_next']")).click();
        }
        return this;
    }

    public List<Employees> getEmployees(int x, int y) {
        for (WebElement row : driver.findElements(rows)) {
            String age = row.findElement(By.xpath(".//td[4]")).getText();
            String salary = row.findElement(By.xpath(".//td[6]")).getText();
            String salarySub = salary.substring(salary.indexOf("$") + 1, salary.indexOf("/y"));
            int ageNum = Integer.valueOf(age);
            Integer salaryNum = Integer.valueOf(salarySub.replaceAll(",", ""));
            String name = row.findElement(By.xpath(".//td[1]")).getText();
            String position = row.findElement(By.xpath(".//td[2]")).getText();
            String office = row.findElement(By.xpath(".//td[3]")).getText();
            if (ageNum > x && salaryNum <= y) {
                employees.add(getEmployee(name, position, office));
            }
        }
        return employees;
    }

    private Employees getEmployee(String name, String position, String office) {
        Employees objectOfEmployees = new Employees(name, position, office);
        return objectOfEmployees;
    }
}
