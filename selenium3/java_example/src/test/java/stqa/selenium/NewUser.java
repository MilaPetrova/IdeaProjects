package stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Created on 12/22/2016.
 */
public class NewUser extends Login {
    @Test
    public void Create(){
        login2();
        driver.findElement(By.linkText("New customers click here")).click();
        driver.findElement(By.name("firstname")).sendKeys("Test3");
        driver.findElement(By.name("lastname")).sendKeys("Test3");
        driver.findElement(By.name("address1")).sendKeys("1 Main St.");
        driver.findElement(By.name("postcode")).sendKeys("02100");
        driver.findElement(By.name("city")).sendKeys("Boston");
        driver.findElement(By.xpath("//*[@id=\"create-account\"]/div/form/table/tbody/tr[5]/td[1]/span[2]/span[1]/span")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("United States" + Keys.RETURN);
        driver.findElement(By.xpath("//*[@id=\"create-account\"]/div/form/table/tbody/tr[5]/td[2]/select/option[32]")).click();
        driver.findElement(By.name("email")).sendKeys("superuser3@test.com");
        driver.findElement(By.name("phone")).sendKeys("1231231231");
        driver.findElement(By.name("password")).sendKeys("superuser");
        driver.findElement(By.name("confirmed_password")).sendKeys("superuser");
        driver.findElement(By.name("create_account")).click();
        logout();
    }

    @Test
    public void LoginLogout() {
        login3("superuser3@test.com","superuser");
        logout();
    }

}
