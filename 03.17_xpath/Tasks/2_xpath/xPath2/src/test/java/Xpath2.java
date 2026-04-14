import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath2 {

    @Test
    void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//a[contains(@href, 'elements')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href, 'text-box')]")).click();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Da Kl");
        String randomEmail = RandomString.make() + "@email.com";
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Not your business");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Not your business again");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'border')]")).getText());
        driver.quit();
    }

}
