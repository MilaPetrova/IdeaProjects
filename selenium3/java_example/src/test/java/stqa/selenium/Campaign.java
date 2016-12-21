package stqa.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 12/20/2016.
 */


public class Campaign extends Login {
    @Test
    public void addItem() {
        login2();
        WebElement regularPrice1 = driver.findElement(By.cssSelector(".regular-price"));
        WebElement campaignPrice1 = driver.findElement(By.cssSelector(".campaign-price"));

        List<String> duckHome = new ArrayList<>();
        duckHome.add(driver.findElement(By.cssSelector("#box-campaigns div.name")).getText());
        duckHome.add(regularPrice1.getText());
        duckHome.add(campaignPrice1.getText());

//        System.out.println(regularPrice.getCssValue("color"));
//        System.out.println(regularPrice.getCssValue("text-decoration"));
//        System.out.println(campaignPrice.getCssValue("color"));
//        System.out.println(campaignPrice.getCssValue("font-weight"));
        String regularColor1 = "rgba(119, 119, 119, 1)";
        String regularDecoration1 = "line-through";
        String campaignColor1 = "rgba(204, 0, 0, 1)";
        String campaignFont1 = "bold";

        Assert.assertTrue(regularPrice1.getCssValue("color").contains(regularColor1));
        Assert.assertTrue(regularPrice1.getCssValue("text-decoration").contains(regularDecoration1));
        Assert.assertTrue(campaignPrice1.getCssValue("color").contains(campaignColor1));
        Assert.assertTrue(campaignPrice1.getCssValue("font-weight").contains(campaignFont1));

        driver.findElement(By.cssSelector("#box-campaigns li.product")).click();

        WebElement regularPrice2 = driver.findElement(By.cssSelector(".regular-price"));
        WebElement campaignPrice2 = driver.findElement(By.cssSelector(".campaign-price"));

        String regularColor2 = "rgba(102, 102, 102, 1)";
        String regularDecoration2 = "line-through";
        String campaignColor2 = "rgba(204, 0, 0, 1)";
        String campaignFont2 = "bold";

        Assert.assertTrue(regularPrice2.getCssValue("color").contains(regularColor2));
        Assert.assertTrue(regularPrice2.getCssValue("text-decoration").contains(regularDecoration2));
        Assert.assertTrue(campaignPrice2.getCssValue("color").contains(campaignColor2));
        Assert.assertTrue(campaignPrice2.getCssValue("font-weight").contains(campaignFont2));

        List<String> duckPage = new ArrayList<>();
        duckPage.add(driver.findElement(By.cssSelector("#box-product h1")).getText());
        duckPage.add(regularPrice2.getText());
        duckPage.add(campaignPrice2.getText());

        if (duckHome.size() > 0 || duckPage.size() > 0) {
            Assert.assertEquals(duckPage, duckHome);
        }

    }
}