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
import org.openqa.selenium.support.ui.FluentWait;

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
//		wait.until(function);
		
		}	
		
		
		
//		private Object getCurrentWindowhandle() {
//			// TODO Auto-generated method stub
//			return null;
//		}

		private void implicitWait(int i) {
			driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
			
		}
		
		
		
		
		
		
		}