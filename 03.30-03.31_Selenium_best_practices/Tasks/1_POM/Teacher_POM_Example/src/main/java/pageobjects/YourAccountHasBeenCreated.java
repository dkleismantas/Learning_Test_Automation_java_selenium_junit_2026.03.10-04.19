package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAccountHasBeenCreated extends BasePage {
    @FindBy(css = "#content p")
    private WebElement paragraph;

    public YourAccountHasBeenCreated(WebDriver driver) {
        super(driver);
    }

    public String getParagraph() {
        return paragraph.getText();
    }

}
