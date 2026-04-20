package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utils.BrowserUtils;

public class HomePage extends BasePage {

    @FindBy(css = "#cartCount")
    WebElement cartCount;

    @FindBy(css = ".cart-icon")
    WebElement cartIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String product) throws InterruptedException {
        WebElement addToCartButton = driver.findElement(By.xpath("//*[normalize-space(text())='" + product + "']/parent::*//*[contains(@class,'add')]"));
        BrowserUtils.scrollTo(driver, addToCartButton);
        Thread.sleep(2000);
        addToCartButton.click();
    }

    public String getCartItemCount() {
        return cartCount.getText();
    }

    public void openCart() throws InterruptedException {
        BrowserUtils.scrollTo(driver, cartIcon);
        Thread.sleep(1000);
        cartIcon.click();
    }

    public void viewProduct(String title) {
        WebElement viewButton = driver.findElement(By.xpath("//*[normalize-space(text())='" + title + "']/parent::*//*[contains(@class,'view')]"));
        BrowserUtils.scrollTo(driver, viewButton);
//        Thread.sleep(1000);
        viewButton.click();
    }
}

