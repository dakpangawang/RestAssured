package unitTests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {

	@Test (enabled = false)
	public void postTestStringBody () {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 8,\"firstName\": \"Leo\",\"lastName\": \"Messi\",\"DOB\": \"10/02/1985\",\"deptId\": 60}")
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
}
	@Test (enabled = false)
	public void postTestStringBody400 () {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 8,\"firstName\": \"Leo\",\"lastName\": \"Messi\",\"DOB\": \"10/02/1985\",\"deptId\": 60\"}")
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(400);
	}
	
	@Test (enabled = false)
	public void postTestFileBody500 () {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/student1.json"))
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(500);
	}
	
	@Test (enabled = false)
	public void postTestInputStreamBody () {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("student2.json"))
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test (enabled = false)
	public void postTestByteBody() {
		try {
			RestAssured.given()
			.baseUri("http://localhost:3000")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("student3.json").readAllBytes())
			.basePath("/students")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test (enabled = true)
	public void postTestMapBody () {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 12);
		map.put("firstName", "Andres");
		map.put("lastName", "Inesta");
		map.put("DOB", "11/12/1985");
		map.put("deptId", 70);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
}










