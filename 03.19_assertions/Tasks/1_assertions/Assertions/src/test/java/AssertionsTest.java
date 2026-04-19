import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class AssertionsTest {

    @Test
    void test() throws InterruptedException {
//        Atidaryti http://opencart.abstracta.us/
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://opencart.abstracta.us/");
        //patikrinti:
//          URL
        Assertions.assertEquals("https://opencart.abstracta.us/", driver.getCurrentUrl());
        //#logo teksta
        Assertions.assertEquals("Your Store", driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).getText());
//mygtukas yra - data-original-title="Add to Wish List"
        Assertions.assertTrue(driver.findElement(By.cssSelector("[data-original-title='Add to Wish List']")).isDisplayed());
//texta - Powered By OpenCart Your Store © 2026
        Assertions.assertEquals("Powered By OpenCart\n" +
                "Your Store © 2026", driver.findElement(By.xpath("//p[contains(text(),'Powered By')]")).getText());
//kad svetaineje yra 74 linkai
        Assertions.assertEquals(74, driver.findElements(By.xpath("//a")).size());
//search button (#search button) yra enabled
        Assertions.assertTrue(driver.findElement(By.cssSelector("#search button")).isEnabled());
//search input (#search input) yra matomas
        Assertions.assertTrue(driver.findElement(By.cssSelector("#search input")).isDisplayed());
//pirmas produktas (.product-layout h4) yra "Macbook"
        Assertions.assertEquals("MacBook", driver.findElement(By.cssSelector(".product-layout h4")).getText());
//antro produkto kaina (.product-layout .price) yra $123.20
        WebElement el = driver.findElement(By.xpath("//a[contains(text(),'iPhone')]/../following-sibling::p[2]"));
        String text = el.getText().split("\n")[0];
        Assertions.assertEquals("$123.20", text);
//        patikrint kad Canon EOS 5D alt tekstas yra "Canon EOS 5D"
        Assertions.assertEquals("Canon EOS 5D", driver.findElement(By.cssSelector("[title='Canon EOS 5D']")).getAttribute("alt"));
//Valiuta  (#form-currency strong) yra $
        Assertions.assertEquals("$", driver.findElement(By.cssSelector("#form-currency strong")).getText());
//        ---
        driver.quit();
    }

}
