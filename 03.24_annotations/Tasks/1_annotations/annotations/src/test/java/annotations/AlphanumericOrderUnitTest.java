package annotations;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AlphanumericOrderUnitTest {
    private static StringBuilder output = new StringBuilder("");

    @Test
    void mycTest() {
        output.append("C");
    }

    @Test
    void myATest() {
        output.append("A");
    }

    @Test
    void myBTest() {
        output.append("b");
    }

    @AfterAll
    public static void assertOutput() {
        assertEquals("AbC", output.toString());
    }
}