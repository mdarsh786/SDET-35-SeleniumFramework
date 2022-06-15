package com.bluebird.comcast.contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.comcsat.POM_Repository.ContactInfoPage;
import com.crm.comcsat.POM_Repository.ContactPage;
import com.crm.comcsat.POM_Repository.CreateConatctPage;
import com.crm.comcsat.POM_Repository.HomePage;

import Genric_Utility.BaseClass;

public class Contact1Test extends BaseClass{
	@Test(groups = { "smokeTest","regressionTest"})
	public void createContact() throws EncryptedDocumentException, IOException
	{
		int ran2 = ran1.getRandom();
		String data = exc.getDataFromExcel("arsh", 1, 4)+ran2;
		
		HomePage hp=new HomePage(driver);
		hp.getContactlnk().click();
		//clicking on create contact
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContact();
		//creating the new contact
		CreateConatctPage ccp=new CreateConatctPage(driver);
		ccp.clickOnSave(data);
		//verify the created page information
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actinfo = cip.getContactinfo().getText();
		if(actinfo.contains(data))
		{
			System.out.println("Contact is created and pass");
		}
		else
		{
			System.out.println("Contact is not created and pass");
		}
		cip.clickOnDeletebtn();
		web.switchToAlertWindowAccept(driver, "Are you sure you want to delete this record?");
		
			
	}

}
