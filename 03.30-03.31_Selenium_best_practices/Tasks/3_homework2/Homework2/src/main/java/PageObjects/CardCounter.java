package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utils.ScroolAndClick.scrollAndClick;

public class CardCounter extends BasePage{

    public CardCounter(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cartCount")
    private WebElement cardCounter;

    @FindBy(className = "cart-icon")
    private WebElement linkCartIcon;

    public String getCardCounter() {
        return cardCounter.getText();
    }

    public void clickCartIcon() {
        scrollAndClick(driver, linkCartIcon);
    }
}
