import org.openqa.selenium.WebDriver;
import org.selenim.driver.Driver;
import org.selenim.pages.LogInPage;
import org.selenim.pages.ProfilePage;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getInstance().getWebDriver();
        driver.get("https://mail.yandex.com/");
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginWithData("LoginTestDriver2","test20102");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.actionLogOut();
        Driver.getQuit();
    }
}
