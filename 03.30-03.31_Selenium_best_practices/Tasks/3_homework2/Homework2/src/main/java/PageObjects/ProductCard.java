package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Utils.ScroolAndClick.scrollAndClick;

public class ProductCard extends BasePage {

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "productGrid")
    private WebElement sectionProductList;

    @FindBy(className = "card")
    private List<WebElement> cardList;

//    public void addProductToCard(String... productName) {
//        for (String product : productName) {
//            sectionProductList.findElement(By.xpath("//div[@class='card']//div[contains(text(), '" + product + "')]//following::button[contains(text(), 'Add to Cart')][1]")).sendKeys(Keys.SPACE);
//        }
//    }


    public void addProductToCard(String... productName) {
        for (String product : productName) {
            WebElement button = sectionProductList.findElement(By.xpath("//div[@class='card'][.//div[contains(text(), '" + product + "')]]//button[contains(text(), 'Add to Cart')]"));
            scrollAndClick(driver, button);
        }
    }

    public String getProductName(int productNumber) {
        return cardList.get(productNumber-1).findElement(By.className("title")).getText();
    }

    public void clickProductViewButton(String productName) {
        WebElement button = sectionProductList.findElement(By.xpath("//div[@class='card'][.//div[contains(text(), '" + productName + "')]]//button[contains(text(), 'View')]"));
        scrollAndClick(driver, button);
    }


}
