package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForTable {
    private WebDriver driver;
    private WebElement table;
    private List<ObjectOfEmployees> employees = new ArrayList<>();
    private By countPages = By.xpath("//div[@id='example_paginate']//span//a");
    private By pageActive = By.xpath("//div[@id='example_paginate']//span//a[@class='paginate_button current']");
    private By rows = By.xpath("//table[@id='example']//tbody//tr");

    public ForTable(WebDriver driver) {
        this.driver = driver;
    }

    public void rowSelection(int x, int y) {
        Integer pages = driver.findElements(countPages).size();
        System.out.println("Total pages: " + pages + '\n');
        for(int i = 1; i <= pages; i++) {
            WebElement activeP = driver.findElement(pageActive);
            System.out.println("Active page: " + activeP.getText());
            activeP.click();

            int row = driver.findElements(rows).size();
            System.out.println("Number of rows: " + row);

            for(int r = 1; r <= row; r++) {
                String age = driver.findElement(By.xpath("//table[@id='example']//tbody//tr["+r+"]//td[4]")).getText();
                String salary = driver.findElement(By.xpath("//table[@id='example']//tbody//tr["+r+"]//td[6]")).getText();
                String salarySub = salary.substring(salary.indexOf("$") + 1, salary.indexOf("/y"));

                int ageNum = Integer.valueOf(age);
                Integer salaryNum = Integer.valueOf(salarySub.replaceAll(",", ""));

                String name = driver.findElement(By.xpath("//table[@id='example']//tbody//tr["+r+"]//td[1]")).getText();
                String position = driver.findElement(By.xpath("//table[@id='example']//tbody//tr["+r+"]//td[2]")).getText();
                String office = driver.findElement(By.xpath("//table[@id='example']//tbody//tr["+r+"]//td[3]")).getText();

                if(ageNum > x && salaryNum <= y){
                    System.out.println(name +" | "+ position +" | "+ office +" | "+ age + " | " + salary);
                    System.out.println('\n' + salaryNum);
                    ObjectOfEmployees objectOfEmployees = new ObjectOfEmployees(name, position, office);
                    employees.add(objectOfEmployees);
                }
            }

            String page = Integer.toString(i + 1 );
            try{
                driver.findElement(By.xpath("//div[@id='example_paginate']//span//a[text()='"+ page +"']")).click();
            }catch (NoSuchElementException e){
                Thread.interrupted();
            }

        }
        System.out.println(employees);
    }

}
