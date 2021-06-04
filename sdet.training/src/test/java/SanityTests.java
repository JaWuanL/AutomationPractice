import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

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
}
