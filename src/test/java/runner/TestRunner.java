package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= "src/test/java/features",
		glue= "stepDefinations")

public class TestRunner extends AbstractTestNGCucumberTests {
	
}
