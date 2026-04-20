package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(css = "[value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
