package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endPoints.Students;

public class GetStudentsTest {
	
	Students students;
	
	@BeforeMethod
	public void initTest() {
		students = new Students();
		students.init();
	}
	
	@Test 
	public void getStudentsValidation() {
		students.getStudents();
		students.validateStatusCode(200);
	}

}
