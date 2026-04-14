package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    private WebElement dismissibleAlert;

    public boolean isWarningMessageDisplayed() {
        return dismissibleAlert.isDisplayed();
    }
}
