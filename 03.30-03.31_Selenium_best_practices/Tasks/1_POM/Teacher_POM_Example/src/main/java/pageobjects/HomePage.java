package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[title='My Account']")
    private WebElement myAccountLink;

    @FindBy(css = "[href*='login'")
    private WebElement loginLink;

    @FindBy(css = "[href*='register'")
    private WebElement registerLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMyAccountLink() {
        myAccountLink.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }
}
