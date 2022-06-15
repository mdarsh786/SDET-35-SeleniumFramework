package Practice;

import org.testng.annotations.Test;

public class Module1Test {

	@Test(invocationCount = 3 )
	public void createContact() {
		System.out.println("create contact");
		// int x=1/0;
	}

	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		System.out.println("modify contact");
		int y=1/0;
	}

	@Test(dependsOnMethods = "modifyContactTest")
	public void deletecontactTest() {
		System.out.println("delete contact");
	}

}
