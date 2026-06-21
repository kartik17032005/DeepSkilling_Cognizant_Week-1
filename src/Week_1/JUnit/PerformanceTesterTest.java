package Week_1.JUnit;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {
    private final PerformanceTester tester = new PerformanceTester();

    @Test
    public void testPerformTask() {
        assertTimeout(Duration.ofMillis(150), () -> tester.performTask());
    }
}
