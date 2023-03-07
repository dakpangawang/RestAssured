package unitTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteTest {
	
	@Test 
	public void deleteTest () {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/students/6")
		.log().all()
		.delete()
		.then()
		.log().all()
		.statusCode(200);
	}

}
