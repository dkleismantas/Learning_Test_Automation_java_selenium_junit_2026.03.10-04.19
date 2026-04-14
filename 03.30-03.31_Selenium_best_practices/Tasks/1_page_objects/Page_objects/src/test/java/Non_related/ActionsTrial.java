package Non_related;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsTrial {

    @Test
    void tryActions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(3));
        driver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();
        driver.switchTo().parentFrame();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.xpath("//img[@id='img1']")), driver.findElement(By.xpath("//div[@id='div2']")))
                .perform();
    }
}
