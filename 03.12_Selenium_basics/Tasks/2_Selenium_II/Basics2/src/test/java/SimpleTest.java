import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleTest {

    @Test
    void mySecondtest() {
//        Create a new Selenium test under new Java Class
        WebDriver website = new ChromeDriver();
//        Open https://demo.webocreation.com/
        website.get("http://opencart.abstracta.us/");
//        Enter a wrong product name in Search field (F.e: MaxBook).
        website.findElement(By.cssSelector("[name='search']")).sendKeys("MaxBook");
//        Click Search button.
        website.findElement(By.cssSelector(".btn-default")).click();
//        Check if Search button is displayed.
        System.out.println(website.findElement(By.cssSelector("#button-search")).isDisplayed());
//        Clear first Search field and enter the correct product name (F.e.: Macbook).
        WebElement findSearch = website.findElement(By.cssSelector("[placeholder='Search']"));
        findSearch.clear();
        findSearch.sendKeys("MacBook");
//        Click Search button again.
        website.findElement(By.cssSelector(".btn-default")).click();
//        Count the number of searched items.
        System.out.println(website.findElements(By.cssSelector(".product-layout")).size());
//        Select: Sort by: Price (Low > high)
        new Select(website.findElement(By.cssSelector("#input-sort"))).selectByIndex(3);
//        Retrieve selected option text and print it.
        System.out.println(new Select(website.findElement(By.cssSelector("#input-sort"))).getFirstSelectedOption().getText());
//        Close Browser;
        website.quit();
    }
}
