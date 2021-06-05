package framework.WebDriver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	public WebDriver driver;

	public abstract void getDriver();

	public void quitDriver() {
		driver.quit();
	}
}
