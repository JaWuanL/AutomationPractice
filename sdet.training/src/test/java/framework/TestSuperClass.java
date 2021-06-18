package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import framework.WebDriver.DriverManager;
import framework.WebDriver.DriverManagerFactory;

public abstract class TestSuperClass {

	protected WebDriver driver;

	public Settings settings;

	public void beforeMethod() {
		settings = Settings.getSettings();
		launchWebDriver();
	}

	public void afterMethod(ITestResult result) {	
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			driver.quit();
		}	
	}

	private void launchWebDriver() {
		DriverManager driverManager = DriverManagerFactory.getManager(settings.browserType);
		driverManager.getDriver();
		driver = driverManager.driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(settings.implicitTimeout, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().setScriptTimeout(settings.scriptTimeout, TimeUnit.MILLISECONDS);		
	}
}
