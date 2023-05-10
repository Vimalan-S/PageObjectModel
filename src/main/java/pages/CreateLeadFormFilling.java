package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class CreateLeadFormFilling extends ProjectSpecificMethod{

	public CreateLeadFormFilling(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public CreateLeadFormFilling enterCmpName(String cmpName) throws IOException {
		
		try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpName);
			reportStep(cmpName + " Company Name is entered succesffully", "pass");
		}catch(Exception e) {
			reportStep("Company Name is not entered succesffully" + e, "fail");
		}
		
		return this;
	}
	
	public CreateLeadFormFilling enterfirstName(String firstName) throws IOException {
		
		try {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
			reportStep(firstName + " First Name is entered succesffully", "pass");
		}catch(Exception e) {
			reportStep("First Name is not entered succesffully" + e, "fail");
		}
		
		return this;
	}
	
	public CreateLeadFormFilling enterLastName(String lastName) throws IOException {
		
		try {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			reportStep(lastName + " Last Name is entered succesffully", "pass");
		}catch(Exception e) {
			reportStep("Last Name is not entered succesffully" + e, "fail");
		}
		
		return this;
	}
	
	public CreateLeadFormFilling clickSubmit() throws IOException {
		
		try {
			driver.findElement(By.name("submitButton")).click();
			reportStep("Submit button is clicked succesffully", "pass");
		}catch(Exception e) {
			reportStep("Submit button is not clicked succesffully" + e, "fail");
		}
		
		return this;
	}
}
