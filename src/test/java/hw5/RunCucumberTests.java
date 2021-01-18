package hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/hw5"})
public class RunCucumberTests extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
