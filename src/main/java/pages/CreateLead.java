package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod{

	public CreateLead(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CreateLeadFormFilling clickCreateLead() {	
		driver.findElement(By.linkText("Create Lead")).click();	
		return new CreateLeadFormFilling(driver);
	}
}



