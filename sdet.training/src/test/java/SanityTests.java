import static org.testng.Assert.assertNotNull;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import framework.ConfigurationProvider;
import framework.WebDriver.DriverManager;
import framework.WebDriver.DriverManagerFactory;

public class SanityTests {

	@Test
	public void canLaunchWebDriver() {
		String path = ClassLoader.getSystemResource("chromedriver.exe").getFile();
		System.setProperty("webdriver.chrome.driver", path);  

		String handle = null;
		WebDriver driver = null;
		try {
			driver = new ChromeDriver();
			handle = driver.getWindowHandle();
		}
		finally {
			if(driver != null) {
				driver.quit();
			}
		}
		
		assertNotNull(handle, "The WebDriver should be launched.");
	}
	
	@Test	
	public void canLaunchWebDriverUsingConfigFile() throws Exception {
		String handle = null;
		WebDriver driver = null;
		try {
			
			String file = "config.properties";
			HashMap<String,String> properties = new ConfigurationProvider().getPropertiesFromResourceFile(file);
			String browserType = properties.get("BrowserType");
			DriverManager driverManager = DriverManagerFactory.getManager(browserType);
			driverManager.getDriver();
			driver = driverManager.driver;
			handle = driver.getWindowHandle();
		}
		finally {
			if(driver != null) {
				driver.quit();
			}
		}
		
		assertNotNull(handle, "The WebDriver should be launched.");
	}
}
