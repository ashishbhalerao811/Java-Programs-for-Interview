package pagesPackage;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBasePackage.TestBaseClass;



public class LoginPageClass extends TestBaseClass{

//	WebDriver driver;
//	TestBaseClass testBasec;
	
	
	@FindBy(xpath="//input[@class='form-control' and @name='username']")
	WebElement loginField;
	
	@FindBy(xpath="//input[@class='form-control' and @name='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement crmLogo;
	
	public LoginPageClass() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String validateLoginPageTitle(){
		return driver.getTitle();

	
	}
	
	public boolean validateCRMImage(){
		System.out.println("logo is displayed="+crmLogo.isDisplayed());
		return crmLogo.isDisplayed();
		
		
	}
	
	public void loginToApplication() throws Exception {
		Thread.sleep(2000);
		loginField.sendKeys("ashishbhalerao811");
		
		passwordField.sendKeys("Ashmech*8");
//		Thread.sleep(2000);
//		loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		
//		return new HomePageClass();
		
	}
}
