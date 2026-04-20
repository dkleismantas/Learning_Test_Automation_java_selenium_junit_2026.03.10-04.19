package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForPageTitle;

public class MyAccountPage extends BasePage {
    @FindBy(css = "#content h2")
    private WebElement header;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        waitForPageTitle(driver, "My Account");
        return header.getText();
    }

    public boolean isOpened() {
        return header.isDisplayed();
    }
}
