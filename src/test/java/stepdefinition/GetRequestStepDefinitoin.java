package test.java.stepdefinition;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetRequestStepDefinitoin {
	
	private static ExtentTest exTest;
	private static ExtentReports extent = new  ExtentReports(System.getProperty("user.dir")+"./Extent reports/Status report.html" , true);
	private static List<String> values;
	
	
	@Given("I want to go to {string} API")
	public void i_want_to_go_to_api(String colourLoversURI) {
		exTest = extent.startTest("Start API");
		baseURI = colourLoversURI;
	}

	@When("I send {string} request for any {string}")
	public void i_send_request_for_any(String GetURI, String Attribute ) {

		try { values =
				given().
					header("User-Agent", "PostmanRuntime/7.6.0").
					contentType("text/xml").
					accept(ContentType.XML).
				when().
					get(GetURI).
				then().
					assertThat().
						statusCode(200).
					extract().
						xmlPath().
						getList(Attribute);
		
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	@Then("I validate the outcome to be more than this {int}")
	public void i_validate_the_outcome_to_be_more_than_this(int MaxValue) {
		
		for (String i:values) {
			Assert.assertTrue(Integer.parseInt(i) > MaxValue);
			exTest.log(LogStatus.PASS, "Test passed successfully");
		}
		extent.endTest(exTest);
		extent.flush();
	}

}
