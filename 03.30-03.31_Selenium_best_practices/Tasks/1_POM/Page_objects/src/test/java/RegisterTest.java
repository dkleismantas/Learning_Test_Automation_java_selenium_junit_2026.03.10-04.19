import org.junit.jupiter.api.Test;
import pageobjects.AccountCreationConfirmPage;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.RegistrationPage;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.DataGenerator.*;

public class RegisterTest extends BaseTest{

    HomePage homePage;
    RegistrationPage registrationPage;
    AccountCreationConfirmPage accountCreationConfirmPage;
    MyAccountPage myAccountPage;

    @Test
    public void registrationTest(){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        accountCreationConfirmPage = new AccountCreationConfirmPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registrationPage.typeFirstName(generateFirstName());
        registrationPage.typeLastName(generateLastName());
        registrationPage.typeEmail(generateEmail());
        registrationPage.typeTelephone(generatePhoneNumber());
        registrationPage.typePassword("Labasvakaras1.");
        registrationPage.typeConfirmPassword("Labasvakaras1.");
        registrationPage.clickAgreeButton();
        registrationPage.clickContinueButton();
        assertThat(accountCreationConfirmPage.getPageTitle()).isEqualTo("Your Account Has Been Created!");
        accountCreationConfirmPage.clickContinueButton();
        assertThat(myAccountPage.isMyAccountPresent()).isTrue();
    }

    @Test
    public void registrationTestWithoutAgreePolicy(){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registrationPage.typeFirstName(generateFirstName());
        registrationPage.typeLastName(generateLastName());
        registrationPage.typeEmail(generateEmail());
        registrationPage.typeTelephone(generatePhoneNumber());
        registrationPage.typePassword("Labasvakaras1.");
        registrationPage.typeConfirmPassword("Labasvakaras1.");
        registrationPage.clickContinueButton();
        assertThat(registrationPage.isWarningMessageDisplayed()).isTrue();
    }
}