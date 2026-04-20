import PageObjects.ProductDetails;
import PageObjects.ProductCard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyProductViewTest extends BaseTest{

    ProductCard productCard;
    ProductDetails productDetails;

    @Test
    public void VerifyProductViewTest(){
        productCard = new ProductCard(driver);
        productDetails = new ProductDetails(driver);

        productCard.clickProductViewButton("Mystic Apparatus 1");
        String productTitle = productDetails.getProductTitle();
        Assertions.assertThat(productTitle).isEqualTo(productCard.getProductName(1));
    }
}
