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

public class vtigers {
	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php");
		System.out.println("Enter into Vtiger Application");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			System.out.println("Vtiger  loginpage open successsfull");
		}
		else
		{
			System.out.println("Vtiger loginpage not open successful");
		}
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		System.out.println("Clicked the Submit Button");
		String Homepageurl=driver.getCurrentUrl();
		System.out.println(Homepageurl);
		if(Homepageurl.equals("http://localhost:8888/index.php?action=index&module=Home"))
		{
			System.out.println("Vtiger Homepage open successfull");
		}
		else
		{
			System.out.println("Vtiger Homepage open successfull");
		}
		//Typecasting
		TakesScreenshot ts=( TakesScreenshot)driver;
		//Takescreenshot and store it in a heap area
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\malli\\eclipse-workspace\\SeleniumPractice\\screenshots\\vtigerimage.png");
		Files.copy(src, dest);
		System.out.println("screenshot done successfully");
		driver.close();

	}
}

