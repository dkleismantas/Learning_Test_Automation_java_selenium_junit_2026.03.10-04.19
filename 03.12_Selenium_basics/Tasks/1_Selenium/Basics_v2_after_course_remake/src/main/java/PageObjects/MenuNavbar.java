package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuNavbar extends BasePage{
    public MenuNavbar(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class*='dropdown'] > [href*='desktops']")
    WebElement dropdownDesktops;

    @FindBy(xpath = "//a[normalize-space()='Show All Desktops']")
    WebElement showAllDesktops;


    public void openAllDesktops() {
        dropdownDesktops.click();
        showAllDesktops.click();
    }
}
