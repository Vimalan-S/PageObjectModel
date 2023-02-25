package week7.day2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.day2.base.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod{

	public CreateLead(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CreateLeadFormFilling clickCreateLead() {	
		driver.findElement(By.linkText("Create Lead")).click();	
		return new CreateLeadFormFilling(driver);
	}
}



