package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorIsNegativeTest extends AbstractCalculatorTest {
    @Test(dataProvider = "isNegativeTestData", dataProviderClass = CalculatorDataProvider.class)
    public void testIsNegative(long a, boolean expected) {
        boolean actual = calculator.isNegative(a);
        assertEquals(actual ,expected);
    }
}
