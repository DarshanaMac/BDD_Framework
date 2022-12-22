package cucumbertest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BuggyCarsAPI {

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

//	@Test
//	public void registerNewUser() {
//				
//
//		RestAssured.baseURI = "https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod";
//		RequestSpecification request = RestAssured.given();
//		JSONObject requestParams = new JSONObject();
//		
//		requestParams.put("username", "kamal012");
//		requestParams.put("firstName", "kamal012");
//		requestParams.put("lastName", "kamal022");
//		requestParams.put("password", "User@12345");
//		requestParams.put("confirmPassword", "User@12345");
//		
//		
//		request.body(requestParams.toJSONString());
//		
//		
//		Response response = request.post("/users");
//		
//		ResponseBody body = response.getBody();
//		System.out.println(response.getStatusCode());
//		System.out.println(body.asString());
//
//	}
//	
//	@Test
//	public void voteForCar() {
//		 // Specify the base URL to the RESTful web service
//        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
//        // Get the RequestSpecification of the request to be sent to the server
//        RequestSpecification httpRequest = RestAssured.given();
//
//        Response response = httpRequest.get("");
//
//        // Get the status code of the request. 
//        //If request is successful, status code will be 200
//       int statusCode = response.getStatusCode();
//
//        // Assert that correct status code is returned.
//       Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, 
//         "Correct status code returned");
//	}

}
