package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends AbstractCalculatorTest {
    @Test(dataProvider = "multiplyTestData", dataProviderClass = CalculatorDataProvider.class)
    public void testMultiply(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual ,expected);
    }
}
