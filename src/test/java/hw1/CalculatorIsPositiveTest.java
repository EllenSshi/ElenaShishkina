package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorIsPositiveTest extends AbstractCalculatorTest {
    @Test(dataProvider = "isPositiveTestData", dataProviderClass = CalculatorDataProvider.class)
    public void testIsPositive(long a, boolean expected) {
        boolean actual = calculator.isPositive(a);
        assertEquals(actual ,expected);
    }
}
