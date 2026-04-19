import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath3 {

    @Test
    void test() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://opencart.abstracta.us/");
        driver.findElement(By.xpath("//*[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'register')]")).click();
        driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys("Jon");
        driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys("Simons");
        String randomEmail = RandomString.make() + "@email.com";
        driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys("+37060000000");
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("Hello123.");
        driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys("Hello123.");
        driver.findElement(By.xpath("//*[@name='agree']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).submit();
        driver.quit();
    }

}
