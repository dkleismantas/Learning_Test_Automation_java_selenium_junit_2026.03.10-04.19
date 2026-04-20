package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-firstname")
    private WebElement firstNameInput;

    @FindBy(css = "#input-lastname")
    private WebElement lastNameInput;

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-telephone")
    private WebElement telephoneInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(css = "#input-confirm")
    private WebElement confirmPasswordInput;

    @FindBy(css = "[name='agree']")
    private WebElement agreeButton;

    @FindBy(css = "[value='Continue']")
    private WebElement continueButton;

    public void typeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void typeEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void typeTelephone(String telephone) {
        telephoneInput.sendKeys(telephone);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void typeConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickAgreeButton() {
        agreeButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
