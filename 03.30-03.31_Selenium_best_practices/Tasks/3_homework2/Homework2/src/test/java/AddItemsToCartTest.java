import PageObjects.CardCounter;
import PageObjects.ProductCard;
import PageObjects.ShoppingCartList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddItemsToCartTest extends BaseTest{

    ProductCard productCard;
    CardCounter cardCounter;
    ShoppingCartList shoppingCartList;

    @Test
    public void AddItemsToCartTest(){
        productCard = new ProductCard(driver);
        cardCounter = new CardCounter(driver);
        shoppingCartList = new ShoppingCartList(driver);

        productCard.addProductToCard("Mystic Apparatus 1");
        Assertions.assertThat(cardCounter.getCardCounter()).isEqualTo("1");
        String actual = productCard.getProductName(1);
        cardCounter.clickCartIcon();
        Assertions.assertThat(shoppingCartList.getShoppingCartProductsNames()).contains(actual);
    }
}
