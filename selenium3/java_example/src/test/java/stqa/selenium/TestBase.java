package stqa.selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

//@Test @Before @After @AfterClass @BeforeClass @Ignore @Runwith

/**
 * Created on 11/29/2016.
 */
public class TestBase{
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void start() {
        /*Chrome */
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new ChromeDriver();
//        if (tlDriver.get() != null) {
//            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
//            return;
//        }

//        /*Internet Explorer*/
//        System.setProperty("webdriver.ie.driver", "C:/dev_space/IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
//
//        /*Firefox old scheme*/
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(FirefoxDriver.MARIONETTE, false);
//        driver = new FirefoxDriver(caps);
//
//        /*Firefox new scheme*/
//        System.setProperty("webdriver.gecko.driver", "C:/dev_space/geckodriver.exe");
//        DesiredCapabilities caps = new DesiredCapabilities();
//        driver = new FirefoxDriver(new FirefoxBinary(new File("c:\\Program Files (x86)\\Nightly\\firefox.exe")), new FirefoxProfile(), caps);
//        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);
//        Runtime.getRuntime().addShutdownHook(
//                new Thread(() -> { driver.quit(); driver = null; }));

    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex){
              return false;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isElementNotPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return driver.findElements(locator).size() == 0;
        }finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public boolean areElementsPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver.findElements(locator).size() > 0;
        }finally {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
//        return driver.findElements(locator).size() > 0;
    }

//    @Before
//    public void Login() {
//        driver.get("http://localhost/litecart/admin/login.php");
////                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElement(By.name("username")).sendKeys("admin");
////        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.findElement(By.name("password")).sendKeys("admin");
//        driver.findElement(By.name("login")).click();
//        wait.until(titleIs("My Store"));
//    }
//    @AfterClass
//    public static void stop() {
//        driver.quit();
//        driver = null;
//    }

    public static List<WebElement> getLeftNavList() {
        List<WebElement> list0 = driver.findElements(By.className("name"));
        return list0;
    }
//    public void LeftNavItem() {
//        List<WebElement> listtest=getLeftNavList();
//        WebElement countriesItem = listtest.get(2);
//        System.out.println(countriesItem.getText());
//    }
    public WebElement getCountries() {
        WebElement countries = getLeftNavList().get(2);
        return countries;
}
    public WebElement getZones() {
        WebElement zones = getLeftNavList().get(5);
        return zones;
    }
    public WebElement getCatalog() {
        WebElement catalog = getLeftNavList().get(1);
        return catalog;
    }
}
