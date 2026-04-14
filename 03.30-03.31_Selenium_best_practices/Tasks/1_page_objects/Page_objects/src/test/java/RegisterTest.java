import net.bytebuddy.utility.RandomString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AccountCreationConfirmPage;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.RegistrationPage;
import utils.DataGenerator;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

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
        registrationPage.typeFirstName(DataGenerator.generateFirstName());
        registrationPage.typeLastName(DataGenerator.generateLastName());
        registrationPage.typeEmail(DataGenerator.generateEmail());
        registrationPage.typeTelephone(DataGenerator.generatePhoneNumber());
        registrationPage.typePassword("Labasvakaras1.");
        registrationPage.typeConfirmPassword("Labasvakaras1.");
        registrationPage.clickAgreeButton();
        registrationPage.clickContinueButton();
        accountCreationConfirmPage.clickContinueButton();
        Assertions.assertThat(myAccountPage.isMyAccountPresent()).isTrue();
    }

    @Test
    public void registrationTestWithoutAgreePolicy(){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        registrationPage.typeFirstName(DataGenerator.generateFirstName());
        registrationPage.typeLastName(DataGenerator.generateLastName());
        registrationPage.typeEmail(DataGenerator.generateEmail());
        registrationPage.typeTelephone(DataGenerator.generatePhoneNumber());
        registrationPage.typePassword("Labasvakaras1.");
        registrationPage.typeConfirmPassword("Labasvakaras1.");
        registrationPage.clickContinueButton();
        Assertions.assertThat(registrationPage.isWarningMessageDisplayed()).isTrue();
    }
}