package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {
    @Test(dataProvider = "sumTestData", dataProviderClass = CalculatorDataProvider.class)
    public void testSum(double addendum1, double addendum2, double expected_sum) {
        double actual = calculator.sum(addendum1, addendum2);
        assertEquals(actual, expected_sum);
    }
}
