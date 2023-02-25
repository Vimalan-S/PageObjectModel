package week7.day2.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week7.day2.util.ReadExcel;

public class ProjectSpecificMethod {
	public ChromeDriver driver;
	public String sheetName;
	
	@BeforeMethod
	public void LaunchBrowser() {
		
		// Disable Website notifications
		ChromeOptions optionC = new ChromeOptions();
		
        optionC.addArguments("--disable-notifications");
        
		driver = new ChromeDriver(optionC);

			
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException {
		String[][] readData = ReadExcel.readData(sheetName);
		
		return readData;
	}
}
