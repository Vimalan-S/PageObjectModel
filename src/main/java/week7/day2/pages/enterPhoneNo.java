package week7.day2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week7.day2.base.ProjectSpecificMethod;

public class enterPhoneNo extends ProjectSpecificMethod{
	public enterPhoneNo(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public enterPhoneNo enterPhone(String phNo) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNo);
		return this;
	}
	
	public enterPhoneNo clickFindLead() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		return this;
	}
	
	public ViewLead clickFirstResult() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLead(driver);
	}
}
