import PageObjects.CardCounter;
import PageObjects.ProductsSection;
import PageObjects.ShoppingCartList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddItemsToCartTest extends BaseTest{

    ProductsSection productsSection;
    CardCounter cardCounter;
    ShoppingCartList shoppingCartList;

    @Test
    public void AddItemsToCartTest(){
        productsSection = new ProductsSection(driver);
        cardCounter = new CardCounter(driver);
        shoppingCartList = new ShoppingCartList(driver);

        productsSection.addProductToCard("Mystic Apparatus 1");
        Assertions.assertThat(cardCounter.getCardCounter()).isEqualTo("1");
        String actual = productsSection.getProductName(1);
        cardCounter.clickCartIcon();
        Assertions.assertThat(shoppingCartList.getShoppingCartProductsNames()).contains(actual);
    }
}
