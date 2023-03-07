package unitTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	
	@Test 
	public void putTest () {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 5);
		map.put("firstName", "Sergio");
		map.put("lastName", "Busquests");
		map.put("DOB", "11/12/1987");
		map.put("deptId", 90);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/students/5")
		.contentType(ContentType.JSON)
		.body(map)
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
		
	}

}
