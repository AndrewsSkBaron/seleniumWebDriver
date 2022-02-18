package org.selenim.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class Screenshot {
    private Date date;
    private SimpleDateFormat formatDate;
    private String nameScreen;
    private File screen;

    public void makeScreen(WebDriver driver) {
        date = new Date();
        formatDate = new SimpleDateFormat("hh_m_ss");
        nameScreen = formatDate.format(date) + ".png";
        screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("C:\\Users\\AndreiBaron\\IdeaProjects\\seleniumWebDriver\\src\\main\\resources\\screenshots\\" + nameScreen));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
