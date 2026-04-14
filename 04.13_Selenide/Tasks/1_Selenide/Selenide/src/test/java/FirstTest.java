import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest extends TestBase {
    TodoPage todoPage;

    @BeforeEach
    public void setup(){
        todoPage = new TodoPage();
        open("/");
    }

    @Test
    public void first() {
        todoPage.add("a", "b", "c");

        todoPage.todosShouldBe("a", "b", "c");
        todoPage.toggle("b");

        todoPage.completedTodosShouldBe("b");
        todoPage.activeTodosShouldBe("a", "c");
    }


    @Test
    public void second() {
//        add a b c
        todoPage.add("a", "b", "c");
//        remove b
        todoPage.remove("a");
//        todos should be a, c
        todoPage.todosShouldBe( "b", "c");
    }

    @Test
    public void third() {
        todoPage.add("a", "b", "c");
        todoPage.edit("b", "labas");
        todoPage.todosShouldBe( "a", "labas", "c");
    }
}
