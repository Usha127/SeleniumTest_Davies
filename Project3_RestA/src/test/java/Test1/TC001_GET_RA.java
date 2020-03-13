package Test1;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_RA {
	
	@Test
	public void getWeatherReport() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/Hyderabad");
		
		String responsebody = response.getBody().asString();
		System.out.println("Response body is : "+ responsebody);
		
		int responsecode = response.getStatusCode();
		System.out.println("Response code is : "+ responsecode);
		
		Assert.assertEquals(responsecode, 200);
		
		String statusLine = response.getStatusLine();
		System.out.println("Response line : "+ statusLine);
		
		JsonPath jasonPath = response.jsonPath();
		String city = jasonPath.get("City");
		System.out.println("Response City : "+ city);
		Assert.assertEquals(city, "Hyderabad");
		
		
		
	}

}
