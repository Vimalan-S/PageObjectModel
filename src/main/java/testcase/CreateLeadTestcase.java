package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.CreateLead;

public class CreateLeadTestcase extends ProjectSpecificMethod{
	
	@BeforeTest
	public void setup() {
		sheetName = "CreateLead";
		testName = "CreateLead";
		testDescription = "Create Lead with Mandatory info";
		testCategory = "functional";
		testAuthor = "Vimalan";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateLeadTestcase(String cmpName, String firstName, String lastName) throws IOException {
		new CreateLead(driver)
		.clickCreateLead()
		.enterCmpName(cmpName)
		.enterfirstName(firstName)
		.enterLastName(lastName)
		.clickSubmit();
	}
}
