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

public class Dropbox {


	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.dropbox.com/login");
		System.out.println("Enter url successfully");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Login - Dropbox"))
		{
			System.out.println("Dropbox  loginpage open successsfull");
		}
		else
		{
			System.out.println("Dropbox loginpage not open successful");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='progressive_susi_email']")).sendKeys("medavarapusravya312@gmail.com");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("Sravya@13");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();

		System.out.println("Click on signin Button");
		String Homepagetitle=driver.getTitle();
		System.out.println(Homepagetitle);
		if(Homepagetitle.equals("Login - Dropbox"))
		{
			System.out.println(" Dropbox Homepage open successful");
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
		File dest = new File("C:\\Users\\malli\\eclipse-workspace\\SeleniumPractice\\screenshots\\dropboximage.png");
		Files.copy(src, dest);
		System.out.println("screenshot done successfully");
		driver.close();
	}

}
