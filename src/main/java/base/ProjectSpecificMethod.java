package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.ReadExcel;

public class ProjectSpecificMethod {
	public ChromeDriver driver;
	public String sheetName;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	
	public String testName, testDescription, testCategory, testAuthor;
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Extent Reports/result.html");
		reporter.setAppendExisting(true);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	@BeforeMethod
	public void LaunchBrowser() {
		
		// Disable Website notifications
		ChromeOptions optionC = new ChromeOptions();
		
        optionC.addArguments("--disable-notifications");
        
        node = test.createNode(testName);
        
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
	
	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException {
		String[][] readData = ReadExcel.readData(sheetName);
		
		return readData;
	}
	
	public int takeSnap() throws IOException{
		int randNum = (int)(Math.random()*99999+100000);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./Snaps/img" + randNum +".png");
		FileUtils.copyFile(src, target);
		
		return randNum;
	}
	
	public void reportStep(String stepDetail, String status) throws IOException{
		int randNum = takeSnap();
		
		MediaEntityBuilder builder = MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/img" +randNum+".png");
		MediaEntityModelProvider provider = builder.build();
		
		if(status.equalsIgnoreCase("pass")) node.pass(stepDetail, provider);
		else if(status.equalsIgnoreCase("fail")) {
			node.fail(stepDetail, provider);
			throw new RuntimeException("See ExtentReport for more Details...");
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
}
