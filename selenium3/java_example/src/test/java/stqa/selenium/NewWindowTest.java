package stqa.selenium;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfwindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.Set;

/**
 * Created on 12/23/2016.
 */
public class NewWindowTest extends Login {
   @Test
   public void selectCountry(){
    login1();
    wait.until(presenceOfElementLocated(By.linkText("Countries")));
    driver.findElement(By.linkText("Countries")).click();
    List<WebElement> editIcons = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[7]/a"));
    Integer listLen = editIcons.size();
    for (int i = 0; i < listLen; i++) {
        List<WebElement> countries = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[5]/a"));
        countries.get(i).click();
        List<WebElement> extLinks = driver.findElements(By.cssSelector("#content a[target=_blank]"));
        for (WebElement e : extLinks) {
            Set<String> oldWindows = driver.getWindowHandles();
            e.click();
            assertTrue(wait.until(numberOfwindowsToBe(oldWindows.size() + 1)));
            Set<String> allWindows = driver.getWindowHandles();
            allWindows.removeAll(oldWindows);
            driver.switchTo().window(allWindows.iterator().next());
            driver.close();
            driver.switchTo().window(oldWindows.iterator().next());
            Set<String> newWindows = driver.getWindowHandles();
            assertEquals(oldWindows, newWindows);
        }
        driver.findElement(By.linkText("Countries")).click();
    }
   }
}
