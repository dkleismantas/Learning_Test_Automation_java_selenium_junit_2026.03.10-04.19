package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class MyAccountPage extends BasePage{

    @FindBy(css = "a:nth-child(13)")
    private WebElement logoutLink;

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    private WebElement myAccountHeader;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getLogoutLink() {
        return logoutLink.getText();
    }

    public boolean isMyAccountPresent() {
        Waiters.waitForPageTitle(driver, "My Account");
        return myAccountHeader.isDisplayed();
    }

    public WebElement getMyAccountHeader() {
        return myAccountHeader;
    }
}
