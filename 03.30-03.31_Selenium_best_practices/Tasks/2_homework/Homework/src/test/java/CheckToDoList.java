import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

import static org.assertj.core.api.Assertions.*;

public class CheckToDoList extends BaseTest {

    HomePage homePage;

    @Test
    public void checkToDoList(){
        homePage = new HomePage(driver);

        homePage.sendValuesToToDo("a", "b", "c");
        assertThat(homePage.getToDoListValues()).containsIgnoringNewLines("a", "b", "c");
        homePage.clickToDoValueCheckboxOfProvidedToDoValue("b");
        assertThat(homePage.getCompletedListValues()).contains("b");
        assertThat(homePage.getListNotCompleted()).contains("a", "c");
    }
}