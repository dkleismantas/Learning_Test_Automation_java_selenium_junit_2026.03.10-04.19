import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderAnnotationUnitTest {
    private static StringBuilder output = new StringBuilder("");

    @Test
    @Order(3)
    void firstTest() {
        output.append("a");
    }

    @Test
    @Order(1)
    void secondTest() {
        output.append("b");
    }

    @Test
    @Order(2)
    void thirdTest() {
        output.append("c");
    }

    @AfterAll
    public static void assertOutput() {
        assertEquals("bca", output.toString());
    }
}