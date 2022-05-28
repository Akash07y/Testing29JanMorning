package tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserSerring.Base;
import pomPack.ActiTimeHeader;
import pomPack.LoginPage;

public class TestClass2 extends Base{

	WebDriver driver ;
	ActiTimeHeader actiTimeHeader;
	LoginPage loginPage ;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browser) {
		
		if(browser.equals("ChromeBrowser"))
		{
			driver = openChromeBrowser();
		}
		
		if(browser.equals("FirefoxBrowser"))
		{
			driver = openFirefoxBrowser();;
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

		loginPage.sendUserName();
		loginPage.sendPasswordName();
		loginPage.selectKeepMeLogin();
		loginPage.clickOnLogin();
		
	}
	
	@Test
	public void verifyTaskTab() {
		actiTimeHeader.clickOnTasksTab();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals(url, "http://desktop-b2220qc/tasks/otasklist.do", "task link is not working");
		
		Assert.assertEquals(title, "actiTIME - Open Tasks");
		
		
		if(url.equals("http://desktop-b2220qc/tasks/otasklist.do") && title.equals("actiTIME - Open Tasks"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	
	@Test
	public void verifyReportTab() {
		actiTimeHeader.clickOnReportsTab();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		if(url.equals("http://desktop-b2220qc/tasks/otasklist.do") && title.equals("actiTIME - Open Tasks"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	
	@AfterMethod
	public void logoutFromApplication() {
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
