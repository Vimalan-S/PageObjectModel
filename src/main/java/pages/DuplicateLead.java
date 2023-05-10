package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class DuplicateLead extends ProjectSpecificMethod{
	public DuplicateLead(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public DuplicateLead clickSubmit() throws IOException {
		
		try {
			driver.findElement(By.name("submitButton")).click();
			reportStep("Submit button is clicked succesffully", "pass");
		}catch(Exception e) {
			reportStep("Submit button is not clicked succesffully" + e, "fail");
		}
		
		return this;
	}
}
