package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class FindLeadPage extends ProjectSpecificMethod{

	public FindLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public FindLeadSearch clickFindLead() {	
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadSearch(driver);
	}
}



