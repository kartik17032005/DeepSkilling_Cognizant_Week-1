package Week_1.JUnit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class,
    AssertionsTest.class,
    EvenCheckerTest.class,
    ExceptionThrowerTest.class,
    PerformanceTesterTest.class,
    OrderedTests.class
})
public class AllTests {
}

