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

public class naukri {
	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.naukri.com/");
		System.out.println("Enter url successfully");
		String CurrentUrl = driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com"))
		{
			System.out.println("Login successful");
		}
		else
		{
			System.out.println("Invalid");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("medavarapusravya312@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Sravya@13");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		System.out.println("Clicked on Login Button");
		String Homepageurl=driver.getCurrentUrl();
		System.out.println(Homepageurl);
		if(Homepageurl.contains("https://www.naukri.com/"))
		{
			System.out.println("Homepage open successful");
		}
		else
		{
			System.out.println("Invalid");
		}
		driver.navigate().refresh();
		System.out.println("refresh successfully");
		//Typecasting
		TakesScreenshot ts=( TakesScreenshot)driver;
		//Takescreenshot and store it in a heap area
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\medav\\Downloads\\seleniumpractice\\seleniumpractice\\naukariimage.png");
		Files.copy(src, dest);
		System.out.println("screenshot done successfully");
		driver.close();
	}
}



