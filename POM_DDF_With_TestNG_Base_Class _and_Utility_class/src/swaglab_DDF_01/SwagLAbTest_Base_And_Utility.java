package swaglab_DDF_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLAbTest_Base_And_Utility extends BaseClass
{
	swagLabLoginPage login; // datatype objectname
	swagLabHomePage home;
	SwagLabOpneMenuPage menu;

	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException
	{
		
			initializeBrowser();
		 login= new swagLabLoginPage(m);
		 home= new swagLabHomePage(m);
		 menu= new SwagLabOpneMenuPage(m);
		
		 
	}
	@BeforeMethod
	public void logininApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.inpswagLabLoginPageUsername(Utility_Class.getData(0, 0));
		login.inpswagLabLoginPagepassword(Utility_Class.getData(0, 1));
		login.clickswagLabLoginPageLoginbutton();
		Thread.sleep(2000);
	}
	@Test
	public void verifylogo() throws InterruptedException
	{
		home.clickswagLabHomePageAddtocart();
		boolean actResult = home.getSwagLabHomePageLogo();
		Assert.assertTrue(actResult,"failed: get false test case is failed ");
		
	}
	
	@AfterMethod
	public void logoutfromApp() throws InterruptedException
	{
		home.clickswagLabHomePageOpenmenu();
		menu.clickswagLabMenuPageLogoutbutn();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		m.close();
	}

}
