import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.assertj.core.api.Assertions.*;

public class AssertJ {

    @Test
    void test() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
//        ---
//        Task Text Box:
//        https://demoqa.com/ - assert page title
        assertThat(driver.getTitle()).isEqualTo("demosite");
//        Click on "Elements" - assert page url
        driver.findElement(By.xpath("//a[contains(@href, 'elements')]")).click();
        Thread.sleep(1000);
        assertThat(driver.getCurrentUrl()).isEqualTo("https://demoqa.com/elements");
//        Click on "Text Box" - assert text on center "Text Box"
        driver.findElement(By.xpath("//div[@class='element-list accordion-collapse collapse show']//li[@id='item-0']")).click();
        assertThat(driver.findElement(By.xpath("//h1[normalize-space()='Text Box']")).getText()).isEqualTo("Text Box");
//        assert email input placeHolder
        assertThat(driver.findElement(By.xpath("//input[@id='userEmail']")).getAttribute("placeholder")).isEqualTo("name@example.com");
//        assert Permanent Address input placeholder (should not exist)
        assertThat(driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).getAttribute("placeholder")).isEqualTo("");
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
//        String[] name = driver.findElement(By.xpath("//p[@id='name']")).getText().split(":");
//        assertThat(name[1]).isEqualTo("Da Kl");
//        String[] email = driver.findElement(By.xpath("//p[@id='email']")).getText().split(":");
//        assertThat(email[1]).isEqualTo(randomEmail);
//        String[] cAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText().split(":");
//        assertThat(cAddress[1]).isEqualTo("Not your business");
//        String[] pAdderss = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText().split(":");
//        assertThat(pAdderss[1]).isEqualTo("Not your business again");
        assertThat(driver.findElements(By.xpath("//*[@id='currentAddress']"))).hasSize(2);
        driver.findElement(By.xpath("//span[normalize-space()='Check Box']")).click();
        driver.findElement(By.xpath("//span[@aria-label='Select Home']")).click();
        assertThat(driver.findElement(By.xpath("//div[@id='result']")).getText()).isEqualTo("You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "documents\n" +
                "downloads\n" +
                "notes\n" +
                "commands\n" +
                "workspace\n" +
                "office\n" +
                "wordFile\n" +
                "excelFile\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general");
//        ---
        Thread.sleep(3000);
        driver.quit();
    }

}
