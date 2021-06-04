package foundation;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.TestSuperClass;

public abstract class AutomationPracticeTestsSuperClass extends TestSuperClass {
	
	protected String baseUrl = "http://www.automationPractice.com";

	@BeforeMethod
	public void Setup() {
		super.beforeMethod();		
		driver.navigate().to(baseUrl);
	}
	
	@AfterMethod
	public void Cleanup(ITestResult result) {
		super.afterMethod(result);
	}
}
