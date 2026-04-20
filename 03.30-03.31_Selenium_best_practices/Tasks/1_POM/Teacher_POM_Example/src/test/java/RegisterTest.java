import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import pageobjects.YourAccountHasBeenCreated;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.DataGenerator.generateEmail;

public class RegisterTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    YourAccountHasBeenCreated yourAccountHasBeenCreated;

    @Test
    void userCanRegister() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        yourAccountHasBeenCreated = new YourAccountHasBeenCreated(driver);
        String pass = "12345";
        DataGenerator.generateEmail();
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registerPage.typeFirstName("John");
        registerPage.typeLastName("Doe");
        registerPage.typeEmail(generateEmail());
        registerPage.typeTelephone("1234567890");
        registerPage.typePassword(pass);
        registerPage.typeConfirmPassword(pass);
        registerPage.clickAgreeButton();
        registerPage.clickContinueButton();

        String actual = yourAccountHasBeenCreated.getParagraph();
        String expected = "Congratulations! Your new account has been successfully created!";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void userCantRegisterWithoutAgreePolicy() {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        yourAccountHasBeenCreated = new YourAccountHasBeenCreated(driver);
        String pass = "12345";

        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registerPage.typeFirstName("John");
        registerPage.typeLastName("Doe");
        registerPage.typeEmail(generateEmail());
        registerPage.typeTelephone("1234567890");
        registerPage.typePassword(pass);
        registerPage.typeConfirmPassword(pass);
        registerPage.clickContinueButton();

        assertThat(registerPage.getAlertText())
                .isEqualTo("Warning: You must agree to the Privacy Policy!");
    }
}
