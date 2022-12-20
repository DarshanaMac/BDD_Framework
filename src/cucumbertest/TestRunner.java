package cucumbertest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;


@CucumberOptions(
		features = "Feature"
		,glue={"stepDefinition"}
		)
public class TestRunner {

}
