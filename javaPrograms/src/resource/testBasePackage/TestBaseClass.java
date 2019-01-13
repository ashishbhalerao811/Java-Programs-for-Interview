package testBasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBaseClass() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\Ashish\\git\\Java-Programs-for-Interview\\Java-Programs-for-Interview\\javaPrograms\\src\\resource\\config\\config.properties");
			 prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	 catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	
	public static void initialization() {
		String browser= prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","G:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","G:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		
	
		
	}

}
