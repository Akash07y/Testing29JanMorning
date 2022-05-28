package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before Suite TestClass 1");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test TestClass 1");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass TestClass 1");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod TestClass 1");
	}
	
	@Test 
	public void testB()  {
		System.out.println("test B TestClass 1");
	}
	
	@Test 
	public void testA() {
		System.out.println("test A TestClass 1");
	}

	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod TestClass 1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass TestClass 1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test TestClass 1");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite TestClass 1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test TestClass 1");
	}

}
