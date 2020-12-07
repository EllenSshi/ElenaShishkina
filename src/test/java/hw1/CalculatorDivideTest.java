package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest extends AbstractCalculatorTest {
    @Test(dataProvider = "divideTestData", dataProviderClass = CalculatorDataProvider.class)
    public void testDivide(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }
}
