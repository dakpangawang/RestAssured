package endPoints;

import utils.RestSpecification;

public class Students extends RestSpecification {
	
	private final String ENDPOINT = "/students";
	private final String fileName = "student4.json";
	
	public void getStudents() {
		getCall(ENDPOINT);
	}
	
	public void getEachStudent(int studentId) {
		getCall(ENDPOINT +"/" +studentId);
	}
	
	public void postAStudent() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeAsJson();
		setBasicAuth("user", "pass");
		postCall(ENDPOINT);
	}
}
