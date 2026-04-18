package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDetailsPage extends BasePage {
    @FindBy(css = ".title")
    public WebElement productTitle;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
