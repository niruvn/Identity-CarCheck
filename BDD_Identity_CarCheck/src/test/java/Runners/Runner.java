package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/compareCarDetails.feature"},
        glue = {"com.identity.StepDefinitions"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
