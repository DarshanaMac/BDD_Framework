package cucumbertest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class BuggyCarsAPI {

//	@Test
//	public void test1() {
//
//
//		Response response = RestAssured.get("https://buggy.justtestit.org/register");
//		System.out.println(response.statusCode());
//		System.out.println(response.asString());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.statusLine());
//
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200);
//
//	}
	
	@Test
	public void test2() {


		JSONObject request = new JSONObject();
		request.put("username", "q");
		request.put("firstName", "q");
		request.put("lastName", "q1");
		request.put("password", "User@12345");
		request.put("confirmPassword", "User@12345");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		post("https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod/users").
		then().statusCode(201);

	}
	
}
