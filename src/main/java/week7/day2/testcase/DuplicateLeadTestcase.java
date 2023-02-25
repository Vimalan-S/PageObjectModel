package week7.day2.testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.base.ProjectSpecificMethod;
import week7.day2.pages.CreateLead;
import week7.day2.pages.DuplicateLead;
import week7.day2.pages.FindLeadPage;

public class DuplicateLeadTestcase extends ProjectSpecificMethod{
	
	@BeforeTest
	public void setup() {
		sheetName = "DuplicateLead";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateLeadTestcase(String phNo) throws InterruptedException {
		new FindLeadPage(driver)
		.clickFindLead()
		.clickPhone()
		.enterPhone(phNo)
		.clickFindLead()
		.clickFirstResult()
		.clickDuplicateLead()
		.clickSubmit();		
	}
}
