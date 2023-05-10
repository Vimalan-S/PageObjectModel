package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.CreateLead;
import pages.DuplicateLead;
import pages.FindLeadPage;

public class DuplicateLeadTestcase extends ProjectSpecificMethod{
	
	@BeforeTest
	public void setup() {
		sheetName = "DuplicateLead";
		testName = "DuplicateLead";
		testDescription = "Duplicate Lead with Mandatory info";
		testCategory = "Smoke";
		testAuthor = "Vimalan";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateLeadTestcase(String phNo) throws InterruptedException, IOException {
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
