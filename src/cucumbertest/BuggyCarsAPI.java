package cucumbertest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BuggyCarsAPI {

	/*
	 * 
	 * GET dashboard details
	 * 
	 */
	@Test
	public void getDashboardDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod/dashboard";
		// Get the RequestSpecification of the request to be sent to the server
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("");

		// Get the status code of the request.
		// If request is successful, status code will be 200
		int statusCode = response.getStatusCode();
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "Correct status code returned");
	}
	
	/*
	 * 
	 * Register new user
	 * 
	 */

	@Test
	public void registerNewUser() {
				

		RestAssured.baseURI = "https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod";
		RequestSpecification request = RestAssured.given();
		
		// add user data
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", "Darshana2002");
		requestParams.put("firstName", "Darshana2002");
		requestParams.put("lastName", "Darshana2002");
		requestParams.put("password", "User@12345");
		requestParams.put("confirmPassword", "User@12345");
		
		
		request.body(requestParams.toJSONString());
	
		Response response = request.post("/users");
		ResponseBody body = response.getBody();
		
		
		//check status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /* actual value */, 201 /* expected value */, "Correct status code returned");
	}
	
	
	
	/*
	 * GET car details
	 * 
	 */
	@Test
	public void getCarDetails() {
		 // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod/oauth";
        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest= RestAssured.given().
        		contentType("application/x-www-form-urlencoded; charset=UTF-8").formParam("grant_type", "password").formParam("username", "darshana").formParam("password", "User@12345");
        		
  

		Response response = httpRequest.post("/token");
		
		  String responseBody= response.getBody().asString();
       
          
          JsonPath jsonpath= response.jsonPath();
          String token = jsonpath.getString("access_token");
 
          RestAssured.baseURI = "https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod/makes/c4u1mqnarscc72is00ng?modelsPage=1";
          RequestSpecification httpRequestmodel= RestAssured.given().header("authorization", "bearer " + token);
          
          Response responsemodels =httpRequestmodel.get("");
          
          int statusCode = responsemodels.getStatusCode();
  		
  		
  		// Assert that correct status code is returned.
  		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "Correct status code returned");

	}

}
