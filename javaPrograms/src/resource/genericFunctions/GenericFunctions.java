package genericFunctions;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class GenericFunctions {
	
	final static Logger logger=LogManager.getLogger(GenericFunctions.class);
			
	public enum ElementState{
		
		CLICKABLE, VISIBLE, SELECTED
	}

	public WebDriver driver;
//	public WebDriver driver= Hooks.driver;
	
	//@param webElement
	public void clickElementUsingJS(WebElement webElement) {
		JavascriptExecutor executor=(JavascriptExecutor) this.driver;
		executor.executeScript("arguments[0].click()", webElement);
		
	}
	
	//@param value
	//@param ElementId
		public void setvalueInElementUsingJS(String value, String elementId) {
			JavascriptExecutor executor=(JavascriptExecutor) this.driver;
			executor.executeScript("document.getElementById('"+ elementId + "').value='" + value + "' ");
			
		}
		
		
		//@return
		public String switchToAlertAndGetText() {
			String message="";
			try {
				Alert alert = driver.switchTo().alert();
				logger.info("Switched to Alert");
				implicitWait(2000);
				message=alert.getText();
			} catch (Exception e) {
				logger.info("Alert Not found");
			}
		return message;
		}

		//Accept an Alert
		public void switchToAlertAndAccept() {
			
			try {
				Alert alert = driver.switchTo().alert();
				logger.info("Switched to Alert");
				implicitWait(2000);
				alert.accept();
			} catch (Exception e) {
				logger.info("Alert Not found");
			}
	
		}
		
		
		//Dismiss an Alert
		public void switchToAlertAndDismiss() {
					
			try {
				 Alert alert = driver.switchTo().alert();
				 logger.info("Switched to Alert");
				 implicitWait(2000);
				 alert.dismiss();
				 
				} catch (Exception e) {
					logger.info("Alert Not found");
				}
			
		}
		
		/*
		 * Get current window handle
		 * returns String
		 * */
		public String getCurrentWindowHandle() {
			
			return this.driver.getWindowHandle();
			
		}
		
		/*
		 * Switch To new Window
		 * @param window
		 * */
		public void switchToWindow(int window) {
			ArrayList<String> allTabs= new ArrayList<String>(this.driver.getWindowHandles());
			allTabs.remove(getCurrentWindowHandle());
			this.driver.switchTo().window(allTabs.get(window));
			
		}
		
		
		/*
		 * Switch To default Content
		 * */
		public void switchToDefaultContent() {

			this.driver.switchTo().defaultContent();
			
		}
		
		
		/*
		 * Click a WebElement
		 * */
		public void clickAWebElement(WebElement webElement) {
			if(webElement.isDisplayed()) {
				webElement.click();
			} else {
				
				logger.info("Element not Displayed");
			}
		}
		
		
		
		/*
		 * Get Attribute for a WebElement
		 * @param webElement
		 * @param attributeName
		 * @return
		 * */
		public String getAttributeOfAWebElement(WebElement webElement, String attributeName) {
			String attributeValue="";
			if(webElement.isDisplayed()) {
				webElement.getAttribute(attributeName);
			}else {
				
				logger.info("Element is Not Displayed");
			}
			return attributeValue;
		}
		
		
		
		/*
		 * Get Text of a WebElement
		 * @param webElement
		 * @return
		 * */
		public String getTextOfAWebElement(WebElement webElement) {
			String textValue="";
			if(webElement.isDisplayed()) {
				webElement.getText();
			}else {
				
				logger.info("Element is Not Displayed");
			}
			return textValue;
		}
		
		
		
		/*
		 * Verify is a WebElement Enabled
		 * @param webElement
		 * @return
		 * */
		public boolean isAWebElementEnabled(WebElement webElement) {
			boolean flag=false;
			
			if(webElement.isDisplayed()) {
				flag=webElement.isEnabled();
			}else {
				
				logger.info("Element is Not Displayed");
			}
			return flag;
		}
		
		
		
		
		/*
		 * Verify is a WebElement Selected
		 * @param webElement
		 * @return
		 * */
		public boolean isAWebElementSelected(WebElement webElement) {
			boolean flag=false;
			
			if(webElement.isDisplayed()) {
				flag=webElement.isSelected();
			}else {
				
				logger.info("Element is Not Displayed");
			}
			return flag;
		}
		
		
		
		
		/*
		 * Click a WebElement
		 * */
		public void clickAWebElement(By webElement) {
			this.driver.findElement(webElement).click();
		}
		
		

		/*
		 * Is a WebElement Present
		 * @param webElement
		 * */
		public boolean clickAWebPresent(WebElement element) {
			boolean flag= false;
			try {
				if(element.isDisplayed()) {
					flag=true;
				}
			} catch (NoSuchElementException e) {
				
				logger.info("Unale to find given webelement '{}'", e);
			}
			return flag;
		}
		
		
		/*
		 * Click using JS
		 * @param webElement
		 * */
		public void clickUsingJS(WebElement webElement) {
			try {
				webElement.isDisplayed();
				Thread.sleep(1000);
				JavascriptExecutor executor=(JavascriptExecutor) this.driver;
				executor.executeScript("arguments[0].click()", webElement);
				
			} catch (Exception e) {
				logger.debug("Unable to click on webElement '{}'", e);
			}
			catch (Error e) {
				logger.debug("Unable to click on webElement '{}'", e);
			}
			
		}
		
		
		/*
		 * Click on Link
		 * @param LinkName
		 * */
		public void clickLink(String linkName) {
			try {
				this.driver.findElement(By.linkText(linkName));
//				logger.info("Click on the '{}'", linkName);
				logger.info( linkName);
				
			}catch (Error e) {
				logger.debug("Unable to click on webElement '{}'", e);
			} 
			catch (Exception e) {
				logger.debug("Unable to click on webElement '{}'", e);
			}

		}
		
		
		
		/*
		 * Wait for a WebElement
		 * @param timeOut in Milliseconds
		 * @param polling in Milliseconds
		 * */
		public void waitForElementUsingFluentWait(final WebElement waitForElement, 
					long timeoutinMilliseconds, long pollingInMilliseconds) {
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
					.withTimeout(timeoutinMilliseconds, TimeUnit.SECONDS)
					.pollingEvery(pollingInMilliseconds, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
		
		
		Function<WebDriver, Boolean> function= new Function<WebDriver, Boolean>(){
			public Boolean apply(WebDriver driver) {
				if(waitForElement.isDisplayed()) {
					return true;
				}else {
					return false;
				}
			}
			
		};
		//wait.until(function);
		
		}	
		

		
		/*
		 * ImplicitWait
		 * @param timeOut in Milliseconds
		 * */
		public void implicitWait(long timeInMilliSeconds) {
			driver.manage().timeouts().implicitlyWait(timeInMilliSeconds, TimeUnit.SECONDS);
			
		}
		
		
		
		/*
		 * ExplicitWait
		 * @param timeOut in Milliseconds
		 * @param webelement
		 * @param condition
		 * */
		public void explicitWait(long timeInSeconds, WebElement webElement, ElementState condition) {
			WebDriverWait wait=new WebDriverWait(driver, timeInSeconds);
			
			switch(condition) {
			
			case CLICKABLE:
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
				break;
				
			case SELECTED:
				wait.until(ExpectedConditions.elementToBeSelected(webElement));
				break;	
			
			case VISIBLE:
				wait.until(ExpectedConditions.visibilityOf(webElement));
				break;	
			
			}
			
		}
		
		
		/*
		 * Enter Text in a TextBox
		 * @param element
		 * @param text
		 * */
		public void enterTextInTextBox(WebElement element, String text) {
			element.clear();
			element.click();
			
		}
		
		
		/*
		 * Links on HomePage
		 * @param value
		 * */
		public boolean linksOnHomePage(String value) {
			return this.driver.findElement(By.xpath("//div[contains(@id,'navbar')]//a[contains(text(),'"
													+ value + "')]")).isDisplayed();
		}
		
		
		/*
		 * ScrollIntoViewAndClick
		 * @param locator
		 * */
		public void scrollIntoViewAndClick(By locator) {
			WebElement webElement=driver.findElement(locator);
			JavascriptExecutor executor=(JavascriptExecutor) this.driver;
			executor.executeScript("arguments[0].scrollIntoView(true); arguments[0].click()", webElement);
			
		}
		
		
		/*
		 * ScrollIntoViewAndClickDefault
		 * @param webElement
		 * */
		public void ScrollIntoViewAndClickDefault(WebElement webElement) {
			
			JavascriptExecutor executor=(JavascriptExecutor) this.driver;
			executor.executeScript("arguments[0].scrollIntoView(block: 'center', inline: 'nearest')); arguments[0].click()", webElement);
			
		}
		
		/*
		 * ScrollIntoViewAndClick
		 * @param webElement
		 * */
		public void ScrollIntoViewAndClick(WebElement webElement) {
			
			JavascriptExecutor executor=(JavascriptExecutor) this.driver;
			executor.executeScript("arguments[0].scrollIntoView(true); arguments[0].click()", webElement);
			
		}
		
		/*
		 * Element Exists
		 * @param locator
		 * @return
		 * */
		public boolean elementExists(By locator) {
			long timeOutInSeconds=10;
			try {
				WebDriverWait waitForPresence=new WebDriverWait(driver, timeOutInSeconds);
				waitForPresence.until(ExpectedConditions.presenceOfElementLocated(locator));
				return true;
			} catch (Exception e) {
				
				return false;
			}
		}
		
		/*
		 * Wait for Load
		 * @param driver
		 * */
		public void waitForLoad(WebDriver driver) {
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				//@Override
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor)driver).
							executeScript("return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(pageLoadCondition);
		}
		
		
		/*
		 * Perform Mouse Hover
		 * @param mainTab
		 * @param subTab
		 * @param linkName
		 * */
		public void performMouseHover(WebElement mainTab,WebElement subTab,String linkName ) throws Exception {
			
			try {
				Actions action=new Actions(this.driver);
				action.moveToElement(mainTab).moveToElement(subTab).click(subTab).build().perform();
				implicitWait(5000);
			} catch (Error e) {
				
				throw e;
			}catch (Exception e) {
				
				throw e;
			}
		}
		
		/*
		 * ClickLink
		 * @param WebElement
		 * @param linkName
		 * @param Exception
		 * */
		public void clickLink(WebElement webElement, String linkName) throws Exception {
			try {
				webElement.isDisplayed();
				webElement.click();
				
			}catch (Error e) {
				System.out.println(e);
				throw e;
			} 
			catch (Exception e) {
				System.out.println(e);
				throw e;
			}

		}
		
		/*
		 * Select checkBoxOrRadioButton
		 * @param WebElement
		 * @param checkBoxOrRadioButtonName
		 * @param Exception
		 * */
		public void checkBoxOrRadioButton(WebElement webElement, String checkBoxOrRadioButtonName,
											String value) throws Exception {
			
			try {
				webElement.isDisplayed();
				webElement.click();
				
			}catch (Error e) {
				System.out.println(e);
				throw e;
			} 
			catch (Exception e) {
				System.out.println(e);
				throw e;
			}

		}
		
		
		/*
		 * Select dropDownBox
		 * @param WebElement
		 * @param dropDownName
		 * @param Exception
		 * */
		public void selectDropDownBox(WebElement webElement, String dropDownName,
											String value) throws Exception {
			
			try {
				webElement.isDisplayed();
				Select dropDownSelection=new Select(webElement);
				dropDownSelection.selectByVisibleText(value);
				webElement.click();
				
			}catch (Error e) {
				System.out.println(e);
				throw e;
			} 
			catch (Exception e) {
				System.out.println(e);
				throw e;
			}

		}
		
		
		}