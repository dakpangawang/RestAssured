package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endPoints.Students;

public class PostStudentsTest {
	
	Students students;
	
	@BeforeMethod
	public void init() {
		students = new Students();
		students.init();
	}
	
	@Test
	public void postAStudent() {
		students.postAStudent();
		students.validateStatusCode(201);
		students.validatePayLoadObject("firstName", "Mark");
		students.validate_w_JsonPath("deptId", 90);
	}

}
