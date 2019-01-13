package pagesPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBasePackage.TestBaseClass;

public class HomePageClass extends TestBaseClass{

	@FindBy(xpath="//td[@class='headertext' and @align='left']")
	WebElement userName;
	
	@FindBy(xpath="//i[@class='fa fa-sign-out icon-2x']")
	WebElement logOutBtn;
	
	@FindBy(xpath="//input[@type='image' and @title='View Week']")
	WebElement viewWeekBtn;
	
	public HomePageClass() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean checkUserName() {
		
		return userName.isDisplayed();
	}
	
	public void clickOnLogOutBtn() {
		logOutBtn.click();
		
	}
	
	public void clickOnViewWeekBtn() {
		viewWeekBtn.click();
		
	}
}
