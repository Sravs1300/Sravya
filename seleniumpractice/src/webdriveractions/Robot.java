package webdriveractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class Robot {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriver.ChromeDriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		
		
		
	}
}