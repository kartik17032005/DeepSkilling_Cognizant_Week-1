package Week_1.JUnit;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void firstTest() {
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void secondTest() {
        assertTrue(true);
    }

    @Test
    @Order(3)
    public void thirdTest() {
        assertTrue(true);
    }
}
