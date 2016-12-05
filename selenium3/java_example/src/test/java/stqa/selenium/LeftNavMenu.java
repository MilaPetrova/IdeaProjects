package stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.*;
import static net.sourceforge.htmlunit.cyberneko.HTMLEntities.get;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created on 11/27/2016.
 */

public class LeftNavMenu extends TestBase{
    @Test
    public void Test1() {
        List<WebElement> list0 = driver.findElements(By.className("name"));
        Integer listLen = list0.size();
        for (int i = 0; i < listLen; i++) {
            List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
            WebElement listElement = list1.get(i);
            listElement.click();
            if (isElementPresent(By.className("docs"))) {
                List<WebElement> list2 = driver.findElements(By.className("docs"));
                for (int j = 0; j < list2.size(); j++) {
                    list2.get(j).click();
                    assertTrue(isElementPresent(By.xpath("//h1")));
                }
            }

        }
    }
}