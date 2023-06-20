package webdriveractions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

public class handlingmouseactions
		{
		public static void main(String args[])
		{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https//demo.actitime.com/login.do");
		WebElement LoginBtn=driver.findElement(By.xpath("//div[text()='login']"));
		Actions act=new Actions(driver);
		act.moveToElement(LoginBtn).perform();
		System.out.println("Right click operation performed successfully");
		}
		
	}


