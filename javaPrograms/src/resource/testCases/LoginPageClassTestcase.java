package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesPackage.HomePageClass;
import pagesPackage.LoginPageClass;
import testBasePackage.TestBaseClass;

public class LoginPageClassTestcase extends TestBaseClass{
	LoginPageClass loginPageClass;
	//WebDriver driver;
	HomePageClass homePageClass;
	
	public LoginPageClassTestcase() {
		
		super();
	}

	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginPageClass = new LoginPageClass();
		System.out.println("Browser opened");
	}
	
	
	@Test
	public void loginTest() throws Exception {
		loginPageClass = new LoginPageClass();	
		System.out.println("User will enter loginId and password");
		
			loginPageClass.loginToApplication();
		
	}
//	@Test
//	public void checkTitle() {
//		loginPageClass = new LoginPageClass();	
//		
//		
//		loginPageClass.validateLoginPageTitle();
//	}
//	
	
	@AfterMethod
	public void tearDown(){
		System.out.println("Browser will quit");
		driver.quit();
	}
	
	
}
