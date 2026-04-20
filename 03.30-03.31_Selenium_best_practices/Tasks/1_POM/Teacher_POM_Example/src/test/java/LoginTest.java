import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    String validMail = "your.eata88621@gmail.com";
    String wrongPass = "your.eata8861@gmail.com";

    @Test
    void loginTest() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccountLink();
        homePage.clickLoginLink();

        loginPage.typeEmail(validMail);
        loginPage.typePassword(validMail);
        loginPage.clickLoginButton();

//        V1
        String expected = "My Account";
        String actual = myAccountPage.getHeaderText();
        assertThat(actual).isEqualTo(expected);
//        V2
        assertThat(myAccountPage.isOpened()).isTrue();
    }

    @Test
    void loginTest_negative() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();

        loginPage.typeEmail(validMail);
        loginPage.typePassword(wrongPass);
        loginPage.clickLoginButton();

        assertThat(loginPage.getAlertText())
                .isEqualTo("Warning: No match for E-Mail Address and/or Password.");
    }
}
