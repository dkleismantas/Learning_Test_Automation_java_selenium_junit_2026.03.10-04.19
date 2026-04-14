import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Xpath {

    @Test
    void test() {
//        1.Create two tests that create a New Account using different locator strategies (CSS and xpath) (kolkas darom tik css)
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.webocreation.com/");
        driver.findElement(By.xpath("//div[contains(@class, 'fc-dialog')]//button")).click();
//        ---
        driver.findElement(By.xpath("//i[contains(@class, 'fa-user')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'register')]")).click();
        driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys("Vardenis");
        driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys("Pavardenis");
        String randomEmail = RandomString.make() + "@email.com";
        driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//*[@id='input-custom-field-30']")).clear();
        driver.findElement(By.xpath("//*[@id='input-custom-field-30']")).sendKeys("Disabled");
        new Select(driver.findElement(By.xpath("//*[@id='input-custom-field-29']"))).selectByIndex(3);
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("Hello123456.");
        driver.findElement(By.xpath("//input[@name='agree']")).sendKeys(Keys.SPACE);
        driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).submit();
//        2.Print count of input fields.
        System.out.println(
                driver.findElements(By.xpath("//input[not(@type='hidden')]")).size()
        );
//        3.Print count of input fields in Your Personal Details.
        System.out.println(
                driver.findElements(By.xpath("//fieldset[@id='account']//input")).size()
        );
//        4.Print count of elements with class attribute = "form-control".
        System.out.println(
                driver.findElements(By.xpath(
                        "//*[@class='form-control']")).size()
        );
        driver.quit();
//        5.Make email generation random.
    }
}