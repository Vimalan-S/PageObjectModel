package week7.day2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.day2.base.ProjectSpecificMethod;

public class CreateLeadFormFilling extends ProjectSpecificMethod{

	public CreateLeadFormFilling(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CreateLeadFormFilling enterCmpName(String cmpName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpName);
		return this;
	}
	
	public CreateLeadFormFilling enterfirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		return this;
	}
	
	public CreateLeadFormFilling enterLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		return this;
	}
	
	public CreateLeadFormFilling clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return this;
	}
}
