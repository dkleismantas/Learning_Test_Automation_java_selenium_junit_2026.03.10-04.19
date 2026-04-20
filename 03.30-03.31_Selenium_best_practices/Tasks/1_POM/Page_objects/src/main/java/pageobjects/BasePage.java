package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiters;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    private WebElement dismissibleAlert;

    @FindBy(xpath = "//h2[contains(text(), 'My Account')]")
    private WebElement myAccountHeader;

    public boolean isWarningMessageDisplayed() {
        return dismissibleAlert.isDisplayed();
    }

    public boolean isMyAccountPresent() {
        Waiters.waitForPageTitle(driver, "My Account");
        return myAccountHeader.isDisplayed();
    }
}
