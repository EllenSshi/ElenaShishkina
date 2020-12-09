package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest extends AbstractCalculatorTest {
    @Test(dataProvider = "subtractTestData", dataProviderClass = CalculatorDataProvider.class)
    public void testSubtract(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
