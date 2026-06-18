package OtherTask;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public void beforeEach() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//a[@href='/forms']")).click();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void Test1() {
        driver.findElement(By.xpath("//*[contains(@href, 'practice-form')]")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//input[@id='gender-radio-1']")).click();
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(randomNumber);
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
        new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"))).selectByVisibleText("December");
        new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"))).selectByVisibleText("1990");
        driver.findElement(By.xpath("(//div[@role='gridcell'][contains(text(), '28')])[last()]")).click();
        WebElement input = driver.findElement(By.id("subjectsInput"));
        input.sendKeys("Comp");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option' and text()='Computer Science']")
        ));
        option.click();
        driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']")).click();
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(address);
        WebElement state = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        try {
            state.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", state);
            state.sendKeys(Keys.SPACE);
        }
        option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-3-option-0']")
        ));
        option.click();
        driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys(Keys.SPACE);
        driver.findElement(By.xpath("//div[@id='react-select-4-option-2']")).click();
        driver.findElement(By.xpath("//button[@id='submit']")).submit();
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Student Name')]/following-sibling::td")).getText()).isEqualTo(fName + " " + lName);
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Student Email')]/following-sibling::td")).getText()).isEqualTo(randomEmail);
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Gender')]/following-sibling::td")).getText()).isEqualTo("Male");
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Mobile')]/following-sibling::td")).getText()).isEqualTo(randomNumber);
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Date of Birth')]/following-sibling::td")).getText()).isEqualTo("28 December,1990");
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Subjects')]/following-sibling::td")).getText()).isEqualTo("Computer Science");
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Hobbies')]/following-sibling::td")).getText()).isEqualTo("Reading");
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'Address')]/following-sibling::td")).getText()).isEqualTo(address);
        assertThat(driver.findElement(By.xpath("//tbody//td[contains(text(), 'State and City')]/following-sibling::td")).getText()).isEqualTo("NCR Noida");
    }
}
