package webdriveractions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class outlook {


	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.office.com/");
		System.out.println("Enter url successfully");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Login | Microsoft 365"))
		{
			System.out.println("outlook  loginpage open successsfull");
		}
		else
		{
			System.out.println("outlook loginpage not open successful");
		}
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//a[@id='hero-banner-sign-back-in-to-microsoft-365-link']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys("medavarapusravya312@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sravya@13");
		driver.findElement(By.xpath("//input[@name='Sign in']")).click();
		System.out.println("Clicked on signin Button");
		driver.findElement(By.xpath("//span[text='Don't show this again']")).click();
		driver.findElement(By.xpath("//input[@name='Yes']")).click();
		String Homepageurl=driver.getCurrentUrl();
		System.out.println(Homepageurl);
		if(Homepageurl.contains("https://www.office.com/?auth=1"))
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
		TakesScreenshot ts=( TakesScreenshot)driver;
		//Takescreenshot and store it in a heap area
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\medav\\Downloads\\seleniumpractice\\seleniumpractice\\outlookimage.png");
		Files.copy(src, dest);
		System.out.println("screenshot done successfully");
		driver.close();
	}
}
