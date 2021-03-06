package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//ChromeDriver should be declared as a Global variable. In that process, the local variable
	//ChromeDriver has to be removed.
	public ChromeDriver driver;
   @BeforeMethod
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();//This code is important to open the Browser
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
	//	driver.manage().timeouts().implicitlyWait(5,TimesUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}
   @AfterMethod
	public void postCondition()
	{
		driver.close();
	}
}
