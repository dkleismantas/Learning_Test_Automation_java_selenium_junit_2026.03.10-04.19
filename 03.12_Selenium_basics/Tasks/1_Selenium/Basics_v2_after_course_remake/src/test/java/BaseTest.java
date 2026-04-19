import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.webocreation.com/");
        driver.findElement(By.cssSelector(".fc-dialog button")).click();
        driver.findElement(By.cssSelector("#cookie button:last-child")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
