//package stqa.selenium;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
///**
// * Created on 11/25/2016.
// */
// public class MyFirstTest {
//
//
//    @Test
//    public  void myFirstTest(){
//        driver.get("http://www.google.com/");
//        driver.findElement(By.name("q")).sendKeys("webdriver");
//        driver.findElement(By.name("btnG")).click();
//        wait.until(titleIs("webdriver - Google Search"));
//    }
//
//    @After
//    public void stop(){
//        driver.quit();
//        driver=null;
//    } private WebDriver driver;
//    private WebDriverWait wait;
//
//    @Before
//    public void start(){
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);
//    }
//
//    @Test
//    public  void myFirstTest(){
//        driver.get("http://www.google.com/");
//        driver.findElement(By.name("q")).sendKeys("webdriver");
//        driver.findElement(By.name("btnG")).click();
//        wait.until(titleIs("webdriver - Google Search"));
//    }
//
//    @After
//    public void stop(){
//        driver.quit();
//        driver=null;
//    }
//}*/
