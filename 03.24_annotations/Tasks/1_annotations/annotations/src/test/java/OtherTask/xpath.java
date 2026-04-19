package OtherTask;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class xpath {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void beforeEach() {
        driver.get("https://demo.webocreation.com/");
        driver.findElement(By.xpath("//div[contains(@class, 'fc-dialog')]//button")).click();
    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    void test() {
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
    }



}