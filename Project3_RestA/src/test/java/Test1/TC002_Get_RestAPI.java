/*
 * URL=http://ergast.com/api/f1/2017/circuits.json
 * Read JSON response and print/validate each values/nodes
*/
package Test1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Get_RestAPI {
	
	@Test
	public void getergastreport() {
		RestAssured.baseURI = "http://ergast.com/api/f1/2017";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/circuits.json");
		
		String responsebody = response.getBody().asString();
		System.out.println("Response body is : "+ responsebody);
		
		JsonPath jsonPath = response.jsonPath();
		System.out.println("response value url = "+ jsonPath.get("MRData.url"));
		System.out.println("response value total = "+ jsonPath.get("MRData.total"));
		System.out.println("response value CircuitTable.season = "+ jsonPath.get("MRData.CircuitTable.season"));
		
		
		
		
		
	}
}
