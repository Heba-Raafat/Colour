package test.java.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin ={"pretty",
        		"html:target/colourLovers_Status_Report.html",
                "json:target/colourLovers_Status_Report.json",
                },
        //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        features = "src/test/resources/features",
        glue={"test.java.StepDefs"},
        monochrome = true

        )

public class TestRunner extends AbstractTestNGCucumberTests{
	

}

