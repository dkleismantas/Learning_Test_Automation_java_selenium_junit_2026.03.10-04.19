package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoockiesPage extends BasePage{

    @FindBy(css = ".fc-dialog button")
    private WebElement buttonConsent;

    @FindBy(css = "#cookie button:last-child")
    private WebElement buttonNoThanks;

    public CoockiesPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonConsent(){
        buttonConsent.click();
    }

    public void clickButtonNoThanks(){
        buttonNoThanks.click();
    }
}
