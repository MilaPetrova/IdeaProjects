package stqa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        driver = new ChromeDriver();
//        if (tlDriver.get() != null) {
//            driver = tlDriver.get();
//            wait = new WebDriverWait(driver, 10);
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
    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    @Before
    public void Login() {
        driver.get("http://localhost/litecart/admin/login.php");
//                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }
//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}
