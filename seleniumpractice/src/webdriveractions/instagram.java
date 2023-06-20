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

	public class instagram {

		public static void main(String[] args) throws IOException {

			
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get("https://www.instagram.com/");
			System.out.println("Enter url successfully");
			String title=driver.getCurrentUrl();
			System.out.println(title);
			if(title.equals("https://www.instagram.com/"))
			{
				System.out.println("instagram loginpage open successfull");
			}
			else
			{
				System.out.println("instagram loginpage not open successfull");
			}
      
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sravya_medavarapu");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sravya@13");
		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		System.out.println("Clicked on login button");
		String Homepagetitle=driver.getTitle();
		System.out.println(Homepagetitle);
		if(Homepagetitle.equals("Instagram"))
		{
			System.out.println("Instagram Homepage open successful");
		}
		else
		{
			System.out.println("Instagram Homepage is not open successful");
		}
		driver.navigate().refresh();
		System.out.println("refresh successfully");
		//Typecasting
		TakesScreenshot ts=( TakesScreenshot)driver;
		//Takescreenshot and store it in a heap area
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\medav\\Downloads\\seleniumpractice\\seleniumpractice\\instagramimage.png");
		Files.copy(src, dest);
		System.out.println("screenshot done successfully");
		driver.close();
		}
	}


