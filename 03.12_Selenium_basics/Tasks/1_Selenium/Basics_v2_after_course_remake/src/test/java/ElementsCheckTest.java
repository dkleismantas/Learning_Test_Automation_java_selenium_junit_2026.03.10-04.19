import PageObjects.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ElementsCheckTest extends BaseTest{

    HomePage homePage;
    AccountLoginPage accountLoginPage;
    AccountRegisterPage accountRegisterPage;
    MenuNavbar menuNavbar;
    DesktopsPage desktopsPage;

    @Test
    public void ElementsCheckTest(){
        homePage = new HomePage(driver);
        accountLoginPage = new AccountLoginPage(driver);
        accountRegisterPage = new AccountRegisterPage(driver);
        menuNavbar = new MenuNavbar(driver);
        desktopsPage = new DesktopsPage(driver);

        homePage.clickOnWishList();
        int expectedSearchBoxes = 1;
        int actualSearchBoxes = accountLoginPage.countSearchBoxes();
        assertThat(actualSearchBoxes).isEqualTo(expectedSearchBoxes);
        accountLoginPage.enterRandomEmailAddress();
        accountLoginPage.clearEmailAddress();
        accountLoginPage.clickLogin();
        accountLoginPage.clickContinueButtonToRegisterNewAccount();
        boolean expectedPasswordInputIsEnabled = true;
        boolean actualPasswordInputIsEnabled = accountRegisterPage.isPasswordEnabled();
        assertThat(actualPasswordInputIsEnabled).isEqualTo(expectedPasswordInputIsEnabled);
        boolean expectedShoppingCartIsDisplayed = true;
        boolean actualShoppingCartIsDisplayed = accountRegisterPage.isShoppingCartDisplayed();
        assertThat(actualShoppingCartIsDisplayed).isEqualTo(expectedShoppingCartIsDisplayed);
        boolean expectedAgreeCheckboxIsSelected = false;
        boolean actualAgreeCheckboxIsSelected = accountRegisterPage.isAgreeCheckboxSelected();
        assertThat(actualAgreeCheckboxIsSelected).isEqualTo(expectedAgreeCheckboxIsSelected);
        menuNavbar.openAllDesktops();
        desktopsPage.selectToShowItemsPerPage(25);
        int expectedSelectedItemsPerPage = 25;
        int actualSelectedItemsPerPage = desktopsPage.getSelectedItemsPerPage();
        assertThat(actualSelectedItemsPerPage).isEqualTo(expectedSelectedItemsPerPage);
        desktopsPage.selectToShowItemsPerPageByIndex(3);
        expectedSelectedItemsPerPage = 75;
        actualSelectedItemsPerPage = desktopsPage.getSelectedItemsPerPage();
        assertThat(actualSelectedItemsPerPage).isEqualTo(expectedSelectedItemsPerPage);
    }
}
