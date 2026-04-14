import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.assertj.core.api.Assertions.*;

public class Task {

    WebDriver driver = new ChromeDriver();
    String fName = "Da";
    String lName = "Kl";
    String randomEmail = RandomString.make() + "@" + RandomString.make(3) + ".com";
    String randomNumber =
            java.util.concurrent.ThreadLocalRandom.current()
                    .ints(10, 0, 10)
                    .mapToObj(String::valueOf)
                    .collect(java.util.stream.Collectors.joining());
    String address = "Do not remember";

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//a[@href='/forms']")).click();
        Thread.sleep(1000);
    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.findElement(By.xpath("//span[normalize-space()='Practice Form']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#firstName")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//input[@id='gender-radio-1']")).click();
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(randomNumber);
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
        new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"))).selectByVisibleText("December");
        new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"))).selectByVisibleText("1990");
        driver.findElement(By.xpath("//div[@aria-label='Choose Friday, December 28th, 1990']")).click();
        WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subject.sendKeys("C");
        subject.sendKeys(Keys.DOWN);
        subject.sendKeys(Keys.DOWN);
        subject.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']")).click();
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys(Keys.SPACE);
        driver.findElement(By.xpath("//div[@id='react-select-3-option-0']")).click();
        driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys(Keys.SPACE);
        driver.findElement(By.xpath("//div[@id='react-select-4-option-2']")).click();
        driver.findElement(By.xpath("//button[@id='submit']")).submit();
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='" + fName + " " + lName + "']")).getText()).isEqualTo(fName + " " + lName);
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='" + randomEmail + "']")).getText()).isEqualTo(randomEmail);
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='Male']")).getText()).isEqualTo("Male");
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='" + randomNumber + "']")).getText()).isEqualTo(randomNumber);
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='28 December,1990']")).getText()).isEqualTo("28 December,1990");
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='Computer Science']")).getText()).isEqualTo("Computer Science");
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='Reading']")).getText()).isEqualTo("Reading");
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='" + address + "']")).getText()).isEqualTo(address);
        assertThat(driver.findElement(By.xpath("//td[normalize-space()='NCR Noida']")).getText()).isEqualTo("NCR Noida");
    }
}
