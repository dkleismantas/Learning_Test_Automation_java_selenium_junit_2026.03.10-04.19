package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{
    public AccountRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(css = "[href*='checkout/cart']")
    private WebElement shoppingCartLink;

    @FindBy(name = "agree")
    private WebElement agreeCheckbox;

    public boolean isPasswordEnabled() {
        return passwordInput.isEnabled();
    }

    public boolean isShoppingCartDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public boolean isAgreeCheckboxSelected() {
        return agreeCheckbox.isSelected();
    }
}
