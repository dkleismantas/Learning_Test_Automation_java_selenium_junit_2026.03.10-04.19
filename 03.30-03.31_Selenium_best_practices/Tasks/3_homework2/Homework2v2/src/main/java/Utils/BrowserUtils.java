package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtils {

    public static void scrollTo(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }
}
