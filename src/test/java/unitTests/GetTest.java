package unitTests;

//import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	
	@Test (enabled = false)
	public void getPlayersPrettyPrint() {
		RestAssured.get("http://localhost:3000/students").prettyPrint();
	}
	
	@Test (enabled = false)
	public void getPlayersVar () {
		Response response = RestAssured.get("http://localhost:3000/students");
		System.out.println(response.asString());
	}
	
	@Test (enabled = false)
	public void getPlayersResponseCodeValidationNegativeTest404 () {
		RestAssured.get("http://localhost:3000/students/100")
		.then()
		.statusCode(404);
	}
	
	@Test (enabled = false)
	public void getPlayersLogs() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/students/5")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test (enabled = false)
	public void getPlayersResponseValidation () {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/students/5")
		.then()
		.log().all()
		.statusCode(200)
		.and();
//		.body("id", equaltTo(5));
//		.body("firstName", equaltTo("Sergio"))
//		.body("lastName", equaltTo("Busquests"))
//		.body("DOB", equaltTo("11/12/1987"))
//		.body("deptId", equaltTo(90));
	}
	
	@Test (enabled = true)
	public void getPlayersBaseUriPath () {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/students/5")
		.log().all()
		.get()
		.then()
		.log().all()
		.statusCode(200);
	}
	

}






