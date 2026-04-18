package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

import static Utils.Waiters.waitForShoppingCardAppears;

public class ShoppingCartList extends BasePage{

    public ShoppingCartList(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart-item")
            private List<WebElement> shoppingCartList;

    public List<String> getShoppingCartProductsNames() {
        waitForShoppingCardAppears(driver, Duration.ofSeconds(4));
        return shoppingCartList.stream()
                .map(item -> item.findElement(By.className("title")).getText())
                .toList();
    }
}
