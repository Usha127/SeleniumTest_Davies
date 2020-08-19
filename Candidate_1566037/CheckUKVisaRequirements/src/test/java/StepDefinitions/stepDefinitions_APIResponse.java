package StepDefinitions;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class stepDefinitions_APIResponse {

	public Response response;
	public RequestSpecification httprequest;
	public int actualStatusCode;
	public int expStatusCode;


	@Given("User has valid base URI")
	public void user_sends_api_get_request() {
		try {
			System.out.println("API URL: api.postcodes.io/postcodes/SW1P4JA");
			httprequest = RestAssured.given();
			httprequest.baseUri("http://api.postcodes.io/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("User makes a get request to postcode service")
	public void user_makes_a_get_request_to_postcode_service() {
		try {
			response = httprequest.get("/postcodes/SW1P4JA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Then("User receive response status code as {int}")
	public void user_receive_response_status_code_as(Integer expectedStatusCode) throws PendingException {
		try {
			expStatusCode = expectedStatusCode;
			actualStatusCode = response.getStatusCode();
			System.out.println("Actual Status code: " + actualStatusCode);
			System.out.println("Expected Status code: " + expectedStatusCode);
			
			Assert.assertEquals(expStatusCode, actualStatusCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Validate the response content")
	public void validate_the_response_content() {

		try {
			if (actualStatusCode == expStatusCode) {
				JsonPath jsonPath = response.jsonPath();
				
				System.out.println("-----------------------------------------------");
				System.out.println("PostCode service API response: ");
				System.out.println("response postcode = " + jsonPath.get("result.postcode"));
				System.out.println("response country = " + jsonPath.get("result.country"));
				System.out.println("response region = " + jsonPath.get("result.region"));
				System.out.println("-----------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
