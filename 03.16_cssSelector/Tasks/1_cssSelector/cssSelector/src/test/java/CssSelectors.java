import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CssSelectors {

    @Test
    void test(){
//        1.Create two tests that create a New Account using different locator strategies (CSS and xpath) (kolkas darom tik css)
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.webocreation.com/");
//        driver.findElement(By.cssSelector(".fc-dialog button")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'fc-dialog')]//button")).click();
//        ---
//        driver.findElement(By.cssSelector(".fa-user")).click();
        driver.findElement(By.xpath("//i[contains(@class, 'fa-user')]")).click();
//        driver.findElement(By.cssSelector("a[href*='register']")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'register')]")).click();
//        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Vardenis");
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Vardenis");
//        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Pavardenis");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Pavardenis");
        String randomEmail = RandomString.make() + "@email.com";
//        driver.findElement(By.cssSelector("#input-email")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(randomEmail);
//        driver.findElement(By.cssSelector("#input-custom-field-30")).clear();
        driver.findElement(By.xpath("//input[@id='input-custom-field-30']")).clear();
//        driver.findElement(By.cssSelector("#input-custom-field-30")).sendKeys("Disabled");
        driver.findElement(By.xpath("//input[@id='input-custom-field-30']")).sendKeys("Disabled");
//        new Select(driver.findElement(By.cssSelector("#input-custom-field-29"))).selectByIndex(3);
        new Select(driver.findElement(By.xpath("//select[@id='input-custom-field-29']"))).selectByIndex(3);
//        driver.findElement(By.cssSelector("#input-password")).sendKeys("Hello123456.");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Hello123456.");
//        driver.findElement(By.cssSelector(".btn.btn-primary")).submit();
        driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).submit();
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
    public static String generateRandomEmail(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString()+"@email.com";
    }

}
