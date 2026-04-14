import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {
    @BeforeEach
    public void setUp() {
        Configuration.headless = true;
        Configuration.baseUrl = "https://todomvc.com/examples/emberjs/todomvc/dist";
    }
}
