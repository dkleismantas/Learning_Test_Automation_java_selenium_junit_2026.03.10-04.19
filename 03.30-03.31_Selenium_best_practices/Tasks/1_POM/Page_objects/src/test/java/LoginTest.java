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
        loginPage.typePassword("Labadiena1.");
        loginPage.clickLoginButton();
        assertThat(myAccountPage.isMyAccountPresent()).isTrue();
    }

    @Test
    void loginTestFail() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.typeEmail("laba@diena.lt");
        loginPage.typePassword("Labadiena12.");
        loginPage.clickLoginButton();
        assertThat(loginPage.isWarningMessageDisplayed()).isTrue();
    }

}