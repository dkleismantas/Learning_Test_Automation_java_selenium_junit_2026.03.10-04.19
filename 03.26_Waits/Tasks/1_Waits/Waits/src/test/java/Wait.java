import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class Wait {

    WebDriver driver;

    @BeforeEach
    public void beforeEach() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");
    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        driver.quit();
    }

//  Kiekvienai uzduociai sukurti atskira test metoda.

//  Implicit:
//  Palaukti kol mygtukas su textu "Visible After 5 Seconds"
    @Test
    public void Test1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[@id='visibleAfter']"));
    }

//  Explict:
//  1. Palaukti kol mygtukas (enableAfter) pasidarys enabled
    @Test
    public void Test2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='enableAfter']")));
        assertThat(driver.findElement(By.xpath("//button[@id='enableAfter']")).isEnabled()).isTrue();
    }

//  2. Palaukti kol mygtukas (colorChange) pasidarys raudonas
    @Test
    public void Test3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//button[@id='colorChange']"), "class", "danger"));
        assertThat(driver.findElement(By.xpath("//button[@id='colorChange']")).getAttribute("class")).isEqualTo("mt-4 text-danger btn btn-primary");
    }

//  3. Palaukti kol mygtukas (visibleAfter) pasidarys matomas
    @Test
    public void Test4() {WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
        assertThat(driver.findElement(By.xpath("//button[@id='visibleAfter']")).isDisplayed()).isTrue();
    }

//  Bonus: Palaukti kol mygtukas (enableAfter) pasidarys enabled naudojant implicit wait
    @Test
    public void Test5() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertThat(driver.findElement(By.xpath("//button[@id='enableAfter'][not(@disabled)]")).isEnabled()).isTrue();
    }

}
