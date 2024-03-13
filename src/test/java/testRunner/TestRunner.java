package testRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features//",
		glue = "stepDefinitions",
		monochrome = true,
		tags = "@sanity",
		plugin = {"pretty", "html:test-output"}
)
public class TestRunner {
	// Your test runner code
}

