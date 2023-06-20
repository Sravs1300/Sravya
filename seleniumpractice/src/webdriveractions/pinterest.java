package webdriveractions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class pinterest {

	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.pinterest.ph/login/");
		System.out.println("Enter url successfully");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("pinterest"))
		{
			System.out.println("pinterest  loginpage open successsfull");
		}
		else
		{
			System.out.println("pinterest loginpage not open successful");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("medavarapusravya312@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sravya@13");
		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		System.out.println("Clicked on Login Button");
		String Homepageurl=driver.getCurrentUrl();
		System.out.println(Homepageurl);
		if(Homepageurl.equals("https://www.pinterest.ph/login/"))
		{
			System.out.println("Homepage open successful");
		}
		else
		{
			System.out.println("Invalid");
		}
		driver.navigate().refresh();
		System.out.println("refresh successfull");
		//Typecasting
		TakesScreenshot ts=(TakesScreenshot)driver;
		//Takescreenshot and store it in a heap area
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\medav\\Downloads\\seleniumpractice\\seleniumpractice\\pinterestimage.png");
		Files.copy(src, dest);
		System.out.println("Screenshot done successfully");
			
		driver.close();
	}

}