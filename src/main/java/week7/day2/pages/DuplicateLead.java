package week7.day2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.day2.base.ProjectSpecificMethod;

public class DuplicateLead extends ProjectSpecificMethod{
	public DuplicateLead(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public DuplicateLead clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return this;
	}
}
