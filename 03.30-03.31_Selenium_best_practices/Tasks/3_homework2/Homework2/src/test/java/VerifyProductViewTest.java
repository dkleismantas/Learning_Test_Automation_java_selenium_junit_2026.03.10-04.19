import PageObjects.ProductDetails;
import PageObjects.ProductsSection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyProductViewTest extends BaseTest{

    ProductsSection productsSection;
    ProductDetails productDetails;

    @Test
    public void VerifyProductViewTest(){
        productsSection = new ProductsSection(driver);
        productDetails = new ProductDetails(driver);

        productsSection.clickProductViewButton("Mystic Apparatus 1");
        String productTitle = productDetails.getProductTitle();
        Assertions.assertThat(productTitle).isEqualTo(productsSection.getProductName(1));
    }
}
