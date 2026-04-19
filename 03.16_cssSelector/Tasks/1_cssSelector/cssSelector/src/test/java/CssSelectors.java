import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CssSelectors {

    @Test
    void test(){
//        1.Create test that create a New Account using CSS Selectors.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.webocreation.com/");
        driver.findElement(By.cssSelector(".fc-dialog button")).click();
//        ---
        driver.findElement(By.cssSelector(".fa-user")).click();
        driver.findElement(By.cssSelector("a[href*='register']")).click();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Vardenis");
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Pavardenis");
        String randomEmail = RandomString.make() + "@email.com";
        driver.findElement(By.cssSelector("#input-email")).sendKeys(randomEmail);
        driver.findElement(By.cssSelector("#input-custom-field-30")).clear();
        driver.findElement(By.cssSelector("#input-custom-field-30")).sendKeys("Disabled");
        new Select(driver.findElement(By.cssSelector("#input-custom-field-29"))).selectByIndex(3);
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Hello123456.");
        driver.findElement(By.xpath("//input[@name='agree']")).sendKeys(Keys.SPACE);
        driver.findElement(By.cssSelector("[name='agree']")).sendKeys(Keys.SPACE);
        driver.findElement(By.cssSelector(".btn.btn-primary")).submit();

//        2.Print count of input fields.
        System.out.println(
                driver.findElements(By.cssSelector("div.col-sm-10 .form-control")).size()
        );
//        3.Print count of input fields in Your Personal Details.
        System.out.println(
                driver.findElements(By.cssSelector("#account input")).size()
        );
//        4.Print count of elements with class attribute = "form-control".
        System.out.println(
                driver.findElements(By.cssSelector(".form-control")).size()
        );
        driver.quit();
//        5.Make email generation random.
    }

}
