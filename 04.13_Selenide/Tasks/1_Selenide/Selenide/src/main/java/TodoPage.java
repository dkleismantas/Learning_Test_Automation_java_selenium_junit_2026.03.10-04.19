import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TodoPage {

    private final SelenideElement newTodo = $(".new-todo");
    private final ElementsCollection todos = $$(".todo-list li");

    public void add(String... texts) {
        for (String text : texts) {
            newTodo.setValue(text).pressEnter();
        }
    }

    public void toggle(String todo) {
        todos.findBy(exactText(todo)).$(".toggle").click();
    }

    //     Asserts
    public void todosShouldBe(String... expected) {
        todos.shouldHave(exactTexts(expected));
    }

    public void completedTodosShouldBe(String... expected) {
        todos.filterBy(cssClass("completed")).shouldHave(exactTexts(expected));
    }

    public void activeTodosShouldBe(String... expected) {
        todos.filterBy(not(cssClass("completed"))).shouldHave(exactTexts(expected));
    }

    public void remove(String todoValue) {
        todos.findBy(exactText(todoValue)).hover().$(".destroy").click();
    }

    public void edit(String currentValue, String newValue) {
        todos.findBy(exactText(currentValue)).doubleClick();
        $(".editing .edit").append(Keys.CONTROL + "A").append(newValue).pressEnter();

    }
}