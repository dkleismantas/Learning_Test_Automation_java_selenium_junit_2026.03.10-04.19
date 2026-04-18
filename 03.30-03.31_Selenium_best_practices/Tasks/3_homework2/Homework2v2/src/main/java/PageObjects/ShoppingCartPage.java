package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#cartContainer .title")
    WebElement productTitle;

    public String getProductTitle() {
        return productTitle.getText();
    }
}
