package hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {
    @DataProvider
    public Object[][] sumTestData() {
        return new Object[][] {
                {2.0, 2.0, 4.0},
                {7.5, -7.0, 0.5},
                {-10.9, -0.1, -11.0}
        };
    }

    @DataProvider
    public Object[][] subtractTestData() {
        return new Object[][] {
                {2.0, 2, 0.0},
                {7.5, -7.0, 14.5},
                {-10.9, 0.1, -11.0}
        };
    }

    @DataProvider
    public Object[][] multiplyTestData() {
        return new Object[][] {
                {2.0, 3, 6.0},
                {8, -7.0, -56.0},
                {-10, -0.1, 1}
        };
    }

    @DataProvider
    public Object[][] divideTestData() {
        return new Object[][] {
                {10.0, 5, 2.0},
                {0, -7.0, 0},
                {-10, 0, Double.NEGATIVE_INFINITY}
        };
    }

    @DataProvider
    public Object[][] powTestData() {
        return new Object[][] {
                {2.0, 3, 8.0},
                {0, -7, Double.POSITIVE_INFINITY},
                {1.0, 5, 1},
                {5, 1, 5.0}
        };
    }

    @DataProvider
    public Object[][] isPositiveTestData() {
        return new Object[][] {
                {2, true},
                {-7, false},
                {0, false}
        };
    }

    @DataProvider
    public Object[][] isNegativeTestData() {
        return new Object[][] {
                {2, false},
                {-7, true},
                {0, false}
        };
    }
}
