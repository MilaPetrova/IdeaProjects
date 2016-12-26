package stqa.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created on 12/22/2016.
 */
public class AddToCatalog extends Login{
    @Test
    public void newItem(){
       login1();
        getCatalog().click();
         //    Open catalog
        driver.findElement(By.cssSelector("#doc-catalog span.name")).click();
        driver.findElement(By.linkText("Rubber Ducks")).click();

        //     Get number of items in catalog
        List<WebElement> ducksCatalog = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[3]/a"));
        Integer listLen = ducksCatalog.size();
        //     Add new item
        driver.findElement(By.linkText("Add New Product")).click();
        //     General
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/table/tbody/tr[1]/td/label[1]/input")).click();
        driver.findElement(By.name("name[en]")).sendKeys("Marble Duck");
        driver.findElement(By.name("code")).sendKeys("007");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/table/tbody/tr[7]/td/div/table/tbody/tr[4]/td[1]/input")).click();
        driver.findElement(By.name("quantity")).sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        driver.findElement(By.name("quantity")).sendKeys("15");
        driver.findElement(By.xpath("//*[@id=\"tab-general\"]/table/tbody/tr[8]/td/table/tbody/tr/td[4]/select/option[1]")).click();
        driver.findElement(By.name("date_valid_from")).sendKeys("12/22/2016");
        driver.findElement(By.name("date_valid_to")).sendKeys("12/22/2017");
//        driver.findElement(By.name("save")).click();
        //       Information
        driver.findElement(By.linkText("Information")).click();
        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/table/tbody/tr[1]/td/select/option[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"tab-information\"]/table/tbody/tr[1]/td/select/option[2]")).click();
        driver.findElement(By.name("keywords")).sendKeys("rubber_duck");
        driver.findElement(By.name("short_description[en]")).sendKeys("Beautiful Marble Rubber Duck");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Beautiful Marble Rubber Duck");
        driver.findElement(By.name("head_title[en]")).sendKeys("rubber_duck");
        driver.findElement(By.name("meta_description[en]")).sendKeys("rubber_duck");
        //Prices
        driver.findElement(By.linkText("Prices")).click();
        driver.findElement(By.name("purchase_price")).sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        driver.findElement(By.name("purchase_price")).sendKeys("5.99");
        driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[1]/tbody/tr/td/select/option[2]")).click();
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("19.99");
        //Save product
        driver.findElement(By.name("save")).click();

        //Verify that product added to the catalog
        listLen = listLen + 1;
        List<WebElement> newDucksCatalog = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[3]/a"));
        Integer listLenNew = newDucksCatalog.size();
        Assert.assertEquals(listLen, listLenNew);
    }
}
