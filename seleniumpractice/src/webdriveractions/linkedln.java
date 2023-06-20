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

	public class linkedln {

		public static void main(String[] args) throws InterruptedException, IOException {


			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.get("https://www.linkedin.com/login");
			System.out.println("Enter url successfull");
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equals("LinkedIn Login, Sign in | LinkedIn"))
			{
				System.out.println("Login successful");
			}
			else
			{
				System.out.println("Invalid");
			}
			driver.findElement(By.xpath("//input[@name='session_key']")).sendKeys("medavarapusravya@gmail.com");
			driver.findElement(By.xpath("//input[@name='session_password']")).sendKeys("Sravya@13");
			driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
			System.out.println("Clicked on signin button");
			String Homepagetitle=driver.getTitle();
			System.out.println(Homepagetitle);
			if(Homepagetitle.equals("(7) Feed | LinkedIn"))
			{
				System.out.println("Linkedin Homepage open successful");
			}
			else
			{
				System.out.println("Linkedin Homepage is not open successful");
			}
			driver.navigate().refresh();
			System.out.println("refresh successfully");
			//Typecasting
			TakesScreenshot ts=( TakesScreenshot)driver;
			//Takescreenshot and store it in a heap area
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\medav\\Downloads\\seleniumpractice\\seleniumpractice\\linkedinimage.png");
			Files.copy(src, dest);
			System.out.println("screenshot done successfully");
			driver.close();
		}
	}

