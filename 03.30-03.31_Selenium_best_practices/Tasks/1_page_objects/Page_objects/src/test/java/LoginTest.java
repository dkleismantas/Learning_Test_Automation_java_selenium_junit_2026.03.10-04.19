import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Test
    void loginTest() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.typeEmail("laba@diena.lt");
//        type pass
        loginPage.typePassword("Labadiena1.");
//        click login
        loginPage.clickLoginButton();
//        ASERT (new page!)
        assertThat(myAccountPage.getLogoutLink()).isEqualTo("Logout");
    }

    @Test
    void loginTestFail() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.typeEmail("laba@diena.lt");
//        type pass
        loginPage.typePassword("Labadiena12.");
//        click login
        loginPage.clickLoginButton();
//        ASERT (new page!)
        assertThat(loginPage.isWarningMessageDisplayed()).isTrue();
    }

    @Test
    void loginTestPass2() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.typeEmail("labas@vakaras.lt");
//        type pass
        loginPage.typePassword("Labasvakaras1.");
//        click login
        loginPage.clickLoginButton();
//        ASERT (new page!)
        assertThat(myAccountPage.isMyAccountPresent()).isTrue();
    }
}