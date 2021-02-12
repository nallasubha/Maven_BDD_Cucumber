package testRunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features={"src/test/java/Feature"}, glue = {"stepsImplementation"},plugin = { "html:target/results.html", "message:target/results.ndjson" })
public class JustEatTestRunner extends AbstractTestNGCucumberTests {

   
    }



