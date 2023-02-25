package week7.day2.testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week7.day2.base.ProjectSpecificMethod;
import week7.day2.pages.CreateLead;

public class CreateLeadTestcase extends ProjectSpecificMethod{
	
	@BeforeTest
	public void setup() {
		sheetName = "CreateLead";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateLeadTestcase(String cmpName, String firstName, String lastName) {
		new CreateLead(driver)
		.clickCreateLead()
		.enterCmpName(cmpName)
		.enterfirstName(firstName)
		.enterLastName(lastName)
		.clickSubmit();
	}
}
