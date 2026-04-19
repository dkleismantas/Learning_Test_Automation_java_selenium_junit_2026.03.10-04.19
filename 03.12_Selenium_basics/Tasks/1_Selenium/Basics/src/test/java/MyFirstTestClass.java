import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyFirstTestClass {

    @Test
    void myFirstTest() throws InterruptedException {

        //        Create a new Selenium test under new Java Class
        WebDriver driver = new ChromeDriver();
        //        Open https://demo.webocreation.com/
        driver.get("https://demo.webocreation.com/");
        driver.findElement(By.cssSelector(".fc-dialog button")).click();
//        Click on a wishlist
        driver.findElement(By.cssSelector("#wishlist-total")).click();
//        Count and print a number of search boxes
        System.out.println(driver.findElements(By.cssSelector("[name='search']")).size());
//        Find element of email input field and enter email “email@email.com”
        WebElement findEmailInput = driver.findElement(By.cssSelector("#input-email"));
        findEmailInput.sendKeys("email@email.com");
//        Clear previous field
        findEmailInput.clear();
//        Click Login
        driver.findElement(By.cssSelector("[type='submit'][class='btn btn-primary']")).submit();
//        Click on register a new customer
        driver.findElement(By.cssSelector("[href*='register'][class='btn btn-primary']")).click();
//        Check if the field to input password is enabled and print the result
        System.out.println(driver.findElement(By.cssSelector("[name='password']")).isEnabled());
//        Check if cart element is displayed and print the result
        System.out.println(driver.findElement(By.cssSelector("[title='Shopping Cart']")).isDisplayed());
//        Check if agree checkbox is selected and print the result
        System.out.println(driver.findElement(By.cssSelector("[name='agree']")).isSelected());
//        Go to top menu -> Desktops
        driver.findElement(By.cssSelector("[href='https://demo.webocreation.com/en-gb/catalog/desktops']")).click();
        driver.findElement(By.cssSelector("[href='https://demo.webocreation.com/en-gb/catalog/desktops'][class='dropdown-item']")).click();
//        Select to show 25 items per page
        new Select(driver.findElement(By.cssSelector("#input-limit"))).selectByVisibleText("25");
//        Print selected option from the dropbox
        System.out.println(new Select(driver.findElement(By.cssSelector("#input-limit"))).getFirstSelectedOption().getText());
//        Select 4th option in show items per page dropbox
        new Select(driver.findElement(By.cssSelector("#input-limit"))).selectByIndex(3);
//        Print selected option
        System.out.println(new Select(driver.findElement(By.cssSelector("#input-limit"))).getFirstSelectedOption().getText());
//        Close the window
        driver.quit();
    }
}