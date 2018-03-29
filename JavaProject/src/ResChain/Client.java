package ResChain;

public class Client {
	public static void main(String[] args) {
		ProjectManager projectManager = new ProjectManager(3);
		DepartmentManager departmentManager = new DepartmentManager(7);
		GeneralManager generalManager = new GeneralManager(15);
		
		projectManager.setNextHandler(departmentManager);
		departmentManager.setNextHandler(generalManager);
		
		projectManager.handleRequest(3);
		
		projectManager.handleRequest(4);
		
		projectManager.handleRequest(8);
		
		projectManager.handleRequest(16);
	}
}
