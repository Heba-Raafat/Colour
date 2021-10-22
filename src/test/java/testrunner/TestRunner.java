package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin ={"pretty",
        		"html:Cucumber reports/colourLovers_Status_Report.html"},
        features = "src/test/java/features",
        glue={"stepdefinition"}
 
        )

public class TestRunner extends AbstractTestNGCucumberTests{
	

}

