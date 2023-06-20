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



public class netflix {
	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.netflix.com/in/login");
		System.out.println("Enter url successfully");
		String title=driver.getCurrentUrl();
		System.out.println(title);
		if(title.equals("https://www.netflix.com/in/login"))
		{
			System.out.println("Netflix  loginpage open successsfull");
		}
		else
		{
			System.out.println("Netflix loginpage not open successful");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='userLoginId']")).sendKeys("medavarapusravya@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Priyanka@20");
		driver.findElement(By.xpath("//h1[text()='Sign In']")).click();
		System.out.println("Click on signin Button");
		String Homepageurl=driver.getCurrentUrl();
		System.out.println(Homepageurl);
		if(Homepageurl.contains("https://www.netflix.com/in/login"))
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
		File dest = new File("C:\\Users\\medav\\Downloads\\seleniumpractice\\seleniumpractice\\nefliximage.png");
		Files.copy(src, dest);
		System.out.println("screenshot done successfully");
		driver.close();
	}

}


