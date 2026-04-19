import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

public class AssertJ {

    @Test
    void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
//        ---
//        Task Text Box:
//        https://demoqa.com/ - assert page title
        assertThat(driver.getTitle()).isEqualTo("demosite");
//        Click on "Elements" - assert page url
        driver.findElement(By.xpath("//a[contains(@href, 'elements')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.urlToBe(Objects.requireNonNull(driver.getCurrentUrl())));
        assertThat(driver.getCurrentUrl()).isEqualTo("https://demoqa.com/elements");
//        Click on "Text Box" - assert text on center "Text Box"
        driver.findElement(By.cssSelector("[id='item-0']")).click();
        assertThat(driver.findElement(By.xpath("//h1")).getText()).isEqualTo("Text Box");
//        assert email input placeHolder
        assertThat(driver.findElement(By.xpath("//input[@id='userEmail']")).getAttribute("placeholder")).isEqualTo("name@example.com");
//        assert Permanent Address input placeholder (should not exist)
        assertThat(driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).getAttribute("placeholder")).isEmpty();
//        assert Submit button text
        assertThat(driver.findElement(By.xpath("//button[@id='submit']")).getText()).isEqualTo("Submit");
//        fill all fields and click submit - assert all filled data displayed in output section
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Da Kl");
        String randomEmail = RandomString.make() + "@example.com";
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Not your business");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Not your business again");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        assertThat(driver.findElement(By.xpath("//p[@id='name']")).getText()).contains("Da Kl");
        assertThat(driver.findElement(By.xpath("//p[@id='email']")).getText()).contains(randomEmail);
        assertThat(driver.findElement(By.xpath("//p[@id='currentAddress']")).getText()).contains("Not your business");
        assertThat(driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText()).contains("Not your business again");

        assertThat(driver.findElements(By.xpath("//*[@id='currentAddress']"))).hasSize(2);
        driver.findElement(By.xpath("//li[@id='item-1']")).click();
        driver.findElement(By.xpath("//*[@role='checkbox']")).click();
        assertThat(driver.findElement(By.xpath("//div[@id='result']")).getText()).contains("You have selected");
//        ---
        driver.quit();
    }

}
