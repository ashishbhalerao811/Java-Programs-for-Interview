package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCRMTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","G:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("https://www.freecrm.com/index.html")).sendKeys("ashishbhalerao811");
		driver.findElement(By.xpath("//input[@class='form-control' and @name='password']")).sendKeys("Ashech*8");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		System.out.println("The title of the page is=="+driver.getTitle());
		
		driver.quit();
		
		
	}

}
