package stqa.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created on 12/23/2016.
 */
public class AddToCart extends Login {
    @Test
    public void newCart() {
     login2();
      //Add 3 items to cart
     for (int i = 0; i < 3; i++) {
          driver.findElement(By.xpath("//*[@id=\"box-most-popular\"]/div/ul/li/a[1]")).click();
          int q1 = quantity();
          System.out.println(q1);
          if (isElementPresent(By.name("options[Size]"))) {
                driver.findElement(By.xpath("//*[@class=\"options\"]/select/option[2]")).click();
                driver.findElement(By.name("add_cart_product")).click();
          }else{
                driver.findElement(By.name("add_cart_product")).click();
          }
            int q0 = q1 + 1;
            String text = "" + q0;
            WebElement quantityCart = driver.findElement(By.className("quantity"));
            wait.until(textToBePresentInElement(quantityCart, text));
            int q2 = quantity();
            System.out.println(q2);
            Assert.assertEquals(q1,q2 - 1);
            driver.findElement(By.linkText("Home")).click();
     }
       //Remove all items from cart
     driver.findElement(By.linkText("Checkout »")).click();
     wait.until(presenceOfElementLocated(By.id("order_confirmation-wrapper")));
     List<WebElement> cartRows = driver.findElements(By.xpath("//*[@id=\"order_confirmation-wrapper\"]/table/tbody/tr"));
     int listLen = cartRows.size();
     for (int i = 0; i < 3; i++) {
            driver.findElement(By.name("remove_cart_item")).click();
            listLen = listLen - 1;
            if (listLen > 5) {
                List<WebElement> cartElements = wait.until(numberOfElementsToBe(By.xpath("//*[@id=\"order_confirmation-wrapper\"]/table/tbody/tr"), listLen));
            }else {
                WebElement table = driver.findElement(By.id("order_confirmation-wrapper"));
                wait.until(stalenessOf(table));
            }
     }
     driver.findElement(By.linkText("<< Back")).click();
}
    //get quantity of items in the cart
    private int quantity() {
        String quantity = this.driver.findElement(By.cssSelector("#cart .quantity")).getText();
        return Integer.parseInt(quantity);
    }

}
