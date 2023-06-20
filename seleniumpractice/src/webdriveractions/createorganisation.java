package webdriveractions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createorganisation {

	public static void main(String[] args) throws Throwable {


		// Random Method
		Random r = new Random();
		int num = r.nextInt(500);
		System.out.println(num);

		// Open the Browser
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Login To Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// Click on Organization Link
		driver.findElement(By.linkText("Organizations")).click();

		// Click on Organization Lookup Button
		driver.findElement(By.xpath("//img [@alt=\"Create Organization...\"]")).click();

		// Create Organization
		WebElement Orgname = driver.findElement(By.name("accountname"));
		Orgname.sendKeys("Mani "+num);

		// Save
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		// Verification
		String ORGNAME = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		System.out.println(ORGNAME);

		String ORGHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(ORGHEADER);

		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("Fail");
		}

		// Click on Contacts Link
		driver.findElement(By.xpath("//a [text()='Contacts']")).click();

		// Click on Contacts Lookup Icon Button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Enter last name
		driver.findElement(By.name("lastname")).sendKeys("Kiran "+num);

		//click on the lookup button
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/img[1]")).click();

		//grouping the windows
		Set<String> allwindows = driver.getWindowHandles();
		List<String> windowslist=new ArrayList(allwindows);

		//switching the window 
		driver.switchTo().window(windowslist.get(1));

		//Enter the text in to the textbox
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_txt']"));
		searchBox.sendKeys("Mani "+num);

		//clicking on the search button 
		driver.findElement(By.xpath("//input[@name='search']")).click();


		Thread.sleep(2000);
		//selecting  the search text 
		driver.findElement(By.xpath("//a [@id=\"1\"]")).click();

		//switching the window 
		driver.switchTo().window(windowslist.get(0));

		//clicking on the save button
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();










	}

}
