package Practice;

import org.testng.annotations.Test;
//	@Test
public class ModuleTest {

		@Test(priority = 2 )
		public void createContactTest()
		{
			System.out.println("create contact");
		}
		@Test(priority = 3)
		public void modifyContactTest()
		{
			
			System.out.println("modify contact");
		}
		@Test(priority = 1)
		public void deleteContactTest()
		{
			System.out.println("delete contact");
		}
	

}
