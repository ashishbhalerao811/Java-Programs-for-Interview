package testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagesPackage.ContactsPageClass;
import pagesPackage.HomePageClass;
import pagesPackage.LoginPageClass;
import testBasePackage.TestBaseClass;

public class HomePageClassTest extends TestBaseClass{
	
	LoginPageClass loginPageClass;
	HomePageClass homePageClass;
	ContactsPageClass contactsPageClass;
	
	public HomePageClassTest() {
		
		super();
	}


	@BeforeTest
	public void setUp() throws Exception{
		
		initialization();
		contactsPageClass= new ContactsPageClass();	
		loginPageClass = new LoginPageClass();
		
		loginPageClass.loginToApplication();
		
			
	}
	
	
	@Test
	public void checkUseNameAndClickOnLogOut()  {
		
		System.out.println("Check the username is dislayed or not");
		homePageClass=new HomePageClass();
		driver.switchTo().frame("mainpanel");
		String frameTitle=driver.getTitle();
		System.out.println("The title of the frame is="+frameTitle);
		
		homePageClass.checkUserName();	
		
		
		
		System.out.println("User will click on view week");
		homePageClass.clickOnViewWeekBtn();
		
		System.out.println("User will click on Logout button");
		homePageClass.clickOnLogOutBtn();
	}
	
	
	@AfterMethod
	public void tearDown(){
		System.out.println("Browser will quit");
		driver.quit();
	}
	
	
	
}
