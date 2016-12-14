package stqa.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Liudmila on 12/6/2016.
 */
public class Login extends TestBase{



    public void login1() {
        driver.get("http://localhost/litecart/admin/login.php");
//                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }


    public void login2() {
        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));
    }


}
