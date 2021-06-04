package ControlExtensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ControlExtensionFactory {

	private WebDriver _driver;

	public ControlExtensionFactory(WebDriver driver) {
		_driver = driver;
	}

	public Button getButton(By locator) {
		WebElement element = findElement(locator);

		return new Button(element, _driver);
	}

	private WebElement findElement(By locator) {
		return _driver.findElement(locator);
	}
}
