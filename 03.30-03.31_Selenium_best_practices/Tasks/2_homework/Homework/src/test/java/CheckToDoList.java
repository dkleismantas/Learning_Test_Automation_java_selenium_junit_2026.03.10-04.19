import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

public class CheckToDoList extends BaseTest {

    HomePage homePage;

    @Test
    public void checkToDoList(){
        homePage = new HomePage(driver);

        homePage.sendValuesToToDo("a", "b", "c");
        Assertions.assertThat(homePage.getToDoListValues()).containsIgnoringNewLines("a", "b", "c");
        homePage.clickToDoValueCheckboxOfProvidedToDoValue("b");
        Assertions.assertThat(homePage.getCompletedListValues()).contains("b");
        Assertions.assertThat(homePage.getListNotCompleted()).contains("a", "c");
    }
}