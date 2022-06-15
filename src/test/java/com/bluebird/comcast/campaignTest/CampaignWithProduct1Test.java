package com.bluebird.comcast.campaignTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.comcsat.POM_Repository.CampaignInfoPage;
import com.crm.comcsat.POM_Repository.CampaignPage;
import com.crm.comcsat.POM_Repository.CreateCampaignWithProtPage;
import com.crm.comcsat.POM_Repository.HomePage;

import Genric_Utility.BaseClass;

public class CampaignWithProduct1Test extends BaseClass{
	@Test(groups = { "smokeTest","regressionTest"})
	public void campaignWithProduct() throws EncryptedDocumentException, IOException
	{
		int ran2 = ran1.getRandom();
		String data = exc.getDataFromExcel("arsh", 1, 4)+ran2;
		
		HomePage hp=new HomePage(driver);
		hp.navigatToCampaignPage();
		
		CampaignPage cp= new CampaignPage(driver);
		cp.getCreateCampaign().click();
		
		CreateCampaignWithProtPage ccp=new CreateCampaignWithProtPage(driver);
		ccp.clickOnSelect(data);
		ccp.switchWindow(driver, "Products&action");
		
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		web.wiatForElement(driver,cip.getTextInfo());
		String actinfo = cip.getTextInfo().getText();
		if(actinfo.contains(data))
		{
			System.out.println("Campaign is created and pass");
		}
		else
		{
			System.out.println("Campaign is not created and pass");
		}
		
	}
}
