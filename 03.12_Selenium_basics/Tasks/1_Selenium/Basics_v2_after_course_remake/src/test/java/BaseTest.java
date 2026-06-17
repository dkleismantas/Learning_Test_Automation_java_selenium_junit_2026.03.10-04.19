import PageObjects.CoockiesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver driver;
    CoockiesPage coockiesPage;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        coockiesPage = new CoockiesPage(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.webocreation.com/");
        coockiesPage.clickButtonConsent();
        coockiesPage.clickButtonNoThanks();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
