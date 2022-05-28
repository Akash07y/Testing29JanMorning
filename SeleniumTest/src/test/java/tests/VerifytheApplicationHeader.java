package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserSerring.Base;
import pomPack.ActiTimeHeader;
import pomPack.LoginPage;
import untils.Utility;

public class VerifytheApplicationHeader extends Base{

	WebDriver driver ;
	ActiTimeHeader actiTimeHeader;
	LoginPage loginPage ;
	int testCaseID;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browser) {
		
		if(browser.equals("ChromeBrowser"))
		{
			driver = openChromeBrowser();
		}
		
		if(browser.equals("FirefoxBrowser"))
		{
			driver = openFirefoxBrowser();
		}
		
		if(browser.equals("OperaBrowser"))
		{
			driver = openOperaBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@BeforeClass
	public void launchBrowser() {
		loginPage = new LoginPage(driver) ;
		actiTimeHeader = new ActiTimeHeader(driver);	
	}
	
	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		driver.get("http://desktop-b2220qc/login.do");
		
		Thread.sleep(3000) ;
		
		String data = Utility.getDataFromExcelsheet("UserDetails", 1, 0);
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExcelsheet("UserDetails", 1, 1);
		loginPage.sendPasswordName(data);
		
		loginPage.selectKeepMeLogin();
		loginPage.clickOnLogin();
		
	}
	
	@Test
	public void verifyTaskTab() {
		testCaseID = 1101 ;
		actiTimeHeader.clickOnTasksTab();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "http://desktop-b2220qc/tasks/otasklist.do", "task link is not working");
		
		Assert.assertEquals(title, "actiTIME - Open Tasks");
	}
	
	@Test
	public void verifyReportTab() {
		testCaseID = 2201;
		actiTimeHeader.clickOnReportsTab();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "http://desktop-b2220qc/tasks/otasklist.do", "task link is not working");
		
		Assert.assertEquals(title, "actiTIME - Open Tasks");
	}
	
	@AfterMethod 
	public void logoutFromApplication(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScrrenshot(testCaseID, driver);
		}
		actiTimeHeader.clickOnLogout();
	}
	
	@AfterClass
	public void clearPOMObjects() {
		
		loginPage = null ;
		actiTimeHeader = null;
	}
	
	@AfterTest
	public void closedBrowser() {
		driver.close();
		driver = null;
		System.gc();  // garbage collector
	}
}
