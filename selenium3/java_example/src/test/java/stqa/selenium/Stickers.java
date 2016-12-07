package stqa.selenium;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;
import java.util.List;


public class Stickers extends Login{
    @Test
    public void Test2() {
        login2();
        List<WebElement> duckList = driver.findElements(By.xpath("//li[@class = 'product column shadow hover-light']"));
        Integer listLen = duckList.size();
        for (int i = 0; i < listLen; i++) {
            assertTrue(isElementPresent(By.xpath("//div[contains(@class,'sticker')]")));
            System.out.println("Sticker is present");

        }
    }
}
