package org.selenim.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class WebDriverUtils {

    public void makeScreen(WebDriver driver) {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("hh_m_ss");
        String nameScreen = formatDate.format(date) + ".png";
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("src/main/resources/screenshots/" + nameScreen));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
