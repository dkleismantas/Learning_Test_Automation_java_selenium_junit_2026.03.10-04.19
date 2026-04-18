package PageObjects;

import Utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ProductDetails extends BasePage{

    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "title")
    WebElement productTitle;

    public String getProductTitle(){
        Waiters.waitForProductInformationAppears(driver, Duration.ofSeconds(4));
        return productTitle.getText();
    }
}
