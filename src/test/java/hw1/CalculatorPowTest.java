package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorPowTest extends AbstractCalculatorTest {
    @Test(dataProvider = "powTestData", dataProviderClass = CalculatorDataProvider.class)
    public void testPow(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertEquals(actual ,expected);
    }
}
