package other;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsTest {
    @Test
    void act() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
//kai nepakanka paprasto clicko, naudojam Actions klase kai prireikia kazko specifinio
//pvz double click, right click, drag and drop, scroll, keliu mygtuku spaudima vienu metu ir t.t
        Actions actions = new Actions(driver);
        actions
                .contextClick(driver.findElement(By.cssSelector("#rightClickBtn")))
                .doubleClick(driver.findElement(By.cssSelector("#doubleClickBtn")))
                .click(driver.findElement(By.xpath("//button[.='Click Me']")))
                .perform();

    }

    @Test
    void drg() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(3));
        driver.findElement(By.cssSelector("[type='submit']")).click();
        driver.switchTo().parentFrame();

        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.cssSelector("#drag1")), driver.findElement(By.cssSelector("#div2"))).perform();
        driver.quit();
    }

    @Test
    void JS() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement option = driver.findElement(By.xpath("//div[@id='react-select-3-option-0']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", option);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

    }
}