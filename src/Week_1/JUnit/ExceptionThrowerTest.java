package Week_1.JUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {
    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowException() {
        assertThrows(IllegalArgumentException.class, () -> thrower.throwException());
    }
}
