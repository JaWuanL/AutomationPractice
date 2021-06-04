package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

public abstract class TestSuperClass {

	protected WebDriver driver;

	protected TestSuperClass() {
	}

	public void beforeMethod() {
		String path = ClassLoader.getSystemResource("chromedriver.exe").getFile();
		System.setProperty("webdriver.chrome.driver", path);  

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void afterMethod(ITestResult result) {	
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			driver.quit();
		}	
	}
}
