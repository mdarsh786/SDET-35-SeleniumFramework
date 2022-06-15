package com.bluebird.comcast.campaignTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.crm.comcsat.POM_Repository.CampaignInfoPage;
import com.crm.comcsat.POM_Repository.CampaignPage;
import com.crm.comcsat.POM_Repository.CreateCampaignPage;
import com.crm.comcsat.POM_Repository.HomePage;
import Genric_Utility.BaseClass;

@Listeners()
public class Campaign1Test extends BaseClass{
	@Test(groups = { "smokeTest","regressionTest"})
	public void createcampaign() throws EncryptedDocumentException, IOException
	{
		
		int ran2 = ran1.getRandom();
		String data = exc.getDataFromExcel("arsh", 1, 4)+ran2;
		
		HomePage hp=new HomePage(driver);
		hp.navigatToCampaignPage();
		
		CampaignPage cp= new CampaignPage(driver);
		cp.getCreateCampaign().click();
		
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.campaignText(data);
		
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		SoftAssert s=new SoftAssert();
		web.wiatForElement(driver,cip.getTextInfo());
		String actinfo = cip.getTextInfo().getText();
		Assert.assertEquals(actinfo, data);
//		if(actinfo.contains(data))
//		{
//			System.out.println("Campaign is created and pass");
//		}
//		else
//		{
//			System.out.println("Campaign is not created and pass");
//		}

	}

}
