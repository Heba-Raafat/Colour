package test.java.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin ={"pretty",
        		"html:target/colourLovers_Status_Report.html",
                "json:target/colourLovers_Status_Report.json"},
        features = "src/test/java/features",
        glue={"test.java.stepdefinition"}

        )

public class TestRunner extends AbstractTestNGCucumberTests{
	

}

