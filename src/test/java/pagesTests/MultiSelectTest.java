package pagesTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.seleniumWebDriver.pages.MultiSelect;

import static org.junit.Assert.assertEquals;

public class MultiSelectTest extends BaseClass {
    private Select select;
    private MultiSelect multiSelect;

    @Test
    public void checkSelectRandom() {
        driver.get(urlMultiSelect);
        multiSelect = new MultiSelect(driver);
        multiSelect.selectRandom();
        select = new Select(driver.findElement(By.xpath("//select[@id='multi-select']")));
        assertEquals(true, select.isMultiple());
    }
}
