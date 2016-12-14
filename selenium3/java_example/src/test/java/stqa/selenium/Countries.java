package stqa.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 12/9/2016.
 */
public class Countries extends Login {

    @Test
    public void sortCountries() {
        login1();
        getCountries().click();
        List<WebElement> countriesCells = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[5]"));
        List<String> countriesText = new ArrayList<String>();
        List<String> countriesCellsSorted = new ArrayList<String>();

        for (WebElement e : countriesCells) {
            String s = e.getText();
            countriesText.add(s);
            countriesCellsSorted.add(s);
        }

        Collections.sort(countriesCellsSorted);
        Assert.assertEquals(countriesText, countriesCellsSorted);
    }
    @Test
    public void sortCountriesZones() {
        login1();
        getCountries().click();
        List<WebElement> zonesCount = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[6]"));
        Integer listLen = zonesCount.size();
        System.out.println(zonesCount.size());
        for (int i = 0; i < listLen; i++) {
            List<WebElement> zonesCells = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[6]"));
            String s = zonesCells.get(i).getText();
            int zoneInt = Integer.parseInt(s);
            List<WebElement> countriesCells = driver.findElements(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr/td[5]/a"));

            if (zoneInt != 0) {
                System.out.println("There is a " + zoneInt + " zones in " + i + "th row");
                WebElement test = countriesCells.get(i);
                test.click();
                List<WebElement> zoneNames = driver.findElements(By.xpath("//*[@id=\"table-zones\"]/form/table/tbody/tr/td[3]"));
                List<String> zonesText = new ArrayList<String>();
                List<String> zonesSorted = new ArrayList<String>();

                for (WebElement c : zoneNames) {
                    String z = c.getText();
                    zonesText.add(z);
                    zonesSorted.add(z);
                }
                Collections.sort(zonesSorted);
                Assert.assertEquals(zonesText, zonesSorted);
                driver.findElement(By.linkText("Countries")).click();
            }
        }

    }
}
