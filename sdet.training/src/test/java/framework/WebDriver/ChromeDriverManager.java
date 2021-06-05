package framework.WebDriver;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void getDriver() {
		URL url = ClassLoader.getSystemResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", url.getFile());
		
		driver = new ChromeDriver();	
	}	
}
