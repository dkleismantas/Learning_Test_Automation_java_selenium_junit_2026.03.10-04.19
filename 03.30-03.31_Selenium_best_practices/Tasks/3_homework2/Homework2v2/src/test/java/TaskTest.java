import PageObjects.HomePage;
import PageObjects.ProductDetailsPage;
import PageObjects.ShoppingCartPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest extends BaseTest {
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    ProductDetailsPage productDetailsPage;

    @Test
    public void AddProductToCart() throws InterruptedException {
        String expectedProduct = "Mystic Apparatus 1";
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);


        homePage.addToCart(expectedProduct);
        String expected = "1";
        String actual = homePage.getCartItemCount();
        Assertions.assertThat(actual).isEqualTo(expected);
        homePage.openCart();
        String actualProduct = shoppingCartPage.getProductTitle();
        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @Test
    void viewProduct() {
        String expectedProduct = "Mystic Apparatus 1";
        homePage = new HomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        homePage.viewProduct(expectedProduct);
        String actualProduct = productDetailsPage.getProductTitle();
        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);
    }
}
