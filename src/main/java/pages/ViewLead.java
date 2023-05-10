package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class ViewLead extends ProjectSpecificMethod{
	public ViewLead(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public DuplicateLead clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLead(driver);
	}
	
}
