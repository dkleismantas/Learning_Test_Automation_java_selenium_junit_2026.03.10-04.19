package PageObjects;

import Utils.RandomData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountLoginPage extends BasePage{
    public AccountLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search")
    private List<WebElement> searchBox;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(css = "form#form-login button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "[class='text-end'] [href*='register']")
    private WebElement registerButton;

    public int countSearchBoxes() {
        return searchBox.size();
    }

    public void enterRandomEmailAddress() {
        emailInput.sendKeys(RandomData.randomEmailAddress());
    }

    public void clearEmailAddress() {
        emailInput.clear();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickContinueButtonToRegisterNewAccount() {
        registerButton.click();
    }

}
