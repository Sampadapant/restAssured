package practiceProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class test_get {
	
	@Test
	public void test_1() {
		given().
		when().
		get("https://reqres.in/api/users?page=1")
		.then()
		.statusCode(200).
		assertThat()
		//.body("data.id[0]", equalTo(1) );
		.body("data.id[0]", equalTo(1)).log().all(); //to get the response
		
	}
	
	//find a particular person with last name
	@Test
	public void test_2() {
		given().
		when().
		get("https://reqres.in/api/users?page=1")
		.then()
		.statusCode(200).
		assertThat()
		//.body("data.id[0]", equalTo(1) );
		//.body("data.first_name", hasItems("Eve")).log().all(); //to get the response
		.body("data.first_name", hasItems("Eve", "George")).log().all();
	}
	
	@Test
	public void test_3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "sampada");
		map.put("job", "tester");
		System.out.println(map);
		
		JSONObject payload = new JSONObject();
		payload.put("name", "sampada");
		payload.put("job","tester");
		payload.toJSONString(map); //create a map which has property and value..passing payload to json format..
		//and then converting json to string
		
		given()
		.body(payload.toJSONString(map))
	    .when().
		post("https://reqres.in/api/users").

		then()
		.statusCode(201);
		
	}
	@Test
 	public void test_4 () {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "sampada");
		map.put("job", "tester");
		System.out.println(map);
		
		JSONObject payload = new JSONObject();
		payload.put("name", "sampada");
		payload.put("job","tester");
		payload.toJSONString(map); //create a map which has property and value..passing payload to json format..
		//and then converting json to string
		
		given()
		.body(payload.toJSONString(map))
	    .when().
		put("https://reqres.in/api/users/2").

		then()
		.statusCode(200);
		
	}
	@Test
 	public void test_5() {
		
		given()
	
	    .when().
		delete("https://reqres.in/api/users/2").
		then()
		.statusCode(204);
		
	}

}
 