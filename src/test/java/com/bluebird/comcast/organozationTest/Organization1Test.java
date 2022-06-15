package com.bluebird.comcast.organozationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.comcsat.POM_Repository.CreateOrganizationPage;
import com.crm.comcsat.POM_Repository.HomePage;
import com.crm.comcsat.POM_Repository.OrganizationInfoPage;
import com.crm.comcsat.POM_Repository.OrganizationPage;

import Genric_Utility.BaseClass;

public class Organization1Test extends BaseClass{
	@Test(groups = { "smokeTest","regressionTest"})
	public void createOrg() throws EncryptedDocumentException, IOException {
		
		int ran2 = ran1.getRandom();
		String data = exc.getDataFromExcel("arsh", 1, 3)+ran2;
		
		HomePage hp=new HomePage(driver);
		(hp.getOrganizationlnk()).click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrg();
	
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.clickOnSave(data);
		
		//verify the created page information
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		web.wiatForElement(driver,oip.getTextInfo());
		String actinfo = oip.getTextInfo().getText();
		if(actinfo.contains(data))
		{
			System.out.println("Organization is created and pass");
		}
		else
		{
			System.out.println("Organization is not created and pass");
		}
		
	}

}
