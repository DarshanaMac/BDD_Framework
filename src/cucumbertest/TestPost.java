package cucumbertest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestPost {
	
	@Test
	public void test2() {


		JSONObject request = new JSONObject();
		request.put("username", "darshana20001");
		request.put("firstName", "darshana20001");
		request.put("konara", "konara20001");
		request.put("password", "User@12345");
		request.put("confirmPassword", "User@12345");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		post("https://k51qryqov3.execute-api.ap-southeast-2.amazonaws.com/prod/users").
		then().statusCode(201 );
		
	

	}
}
