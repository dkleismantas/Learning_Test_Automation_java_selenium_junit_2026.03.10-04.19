package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class DesktopsPage extends BasePage{
    public DesktopsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-limit")
    private WebElement showItemsPerPageInput;


    public void selectToShowItemsPerPage(int numberOfItems) {
        Select showItemsPerPageSelect = new Select(showItemsPerPageInput);
        showItemsPerPageSelect.selectByVisibleText(String.valueOf(numberOfItems));
    }

    public int getSelectedItemsPerPage() {
        return Integer.parseInt(new Select(showItemsPerPageInput).getFirstSelectedOption().getText());
    }

    public void selectToShowItemsPerPageByIndex(int index) {
        new Select(showItemsPerPageInput).selectByIndex(index);
    }
}
