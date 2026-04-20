package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationConfirmPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    private WebElement continueButton;

    public AccountCreationConfirmPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
