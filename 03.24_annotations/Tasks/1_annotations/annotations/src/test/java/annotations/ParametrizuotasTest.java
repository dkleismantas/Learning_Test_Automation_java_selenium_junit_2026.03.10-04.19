package annotations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ParametrizuotasTest {
    WebDriver driver;

    @BeforeEach
    void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.get("https://opencart.abstracta.us/");
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Your Store", "OOPS"})
    void testas(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assertions.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,3})
    void testas2(int expectedParam) {
        int actualSize = 3;
        Assertions.assertThat(actualSize).isEqualTo(expectedParam);
    }
}
