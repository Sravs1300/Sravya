package webdriveractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class inox {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.inoxmovies.com/");
		System.out.println("Enter url successfull");
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Book Movie Tickets | Movie Tickets Online - Inox movies"))
		{
			System.out.println("Inox Loginpage open successful");
		}
		else
		{
			System.out.println("Invalid");
		}
		driver.findElement(By.id("ctl00_bodyINOX")).click();
		System.out.println("Select the city");
		driver.findElement(By.xpath("//input[@id='ctl00_tbltb']")).sendKeys("medavarapusravya312@gmail.com");
		driver.findElement(By.xpath("//input[@id='ctl00_tblp']")).sendKeys("Sravya@13");
		driver.findElement(By.xpath("//input[@id='ctl00_btnLogin']")).click();
		System.out.println("Clicked on signin button");
		String Homepageurl=driver.getCurrentUrl();
		System.out.println(Homepageurl);
		if(Homepageurl.contains("https://www.inoxmovies.com/Index.aspx"))
		{
			System.out.println("Inox Homepage open successful");
		}
		else
		{
			System.out.println("Inox Homepage is not open successful");
		}
		driver.close();
	}
}



