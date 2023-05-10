package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class FindLeadSearch extends ProjectSpecificMethod{
	public FindLeadSearch(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public enterPhoneNo clickPhone() throws InterruptedException {
		Thread.sleep(2000);
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Phone']")));
		return new enterPhoneNo(driver);
	}
}
