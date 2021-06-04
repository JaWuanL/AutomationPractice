package controlExtensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ControlExtension {

	protected WebElement mappedElement;
	protected WebDriver driver;

	protected ControlExtension(WebElement mappedElement, WebDriver driver) {
		this.mappedElement = mappedElement;
		this.driver = driver;
	}
}
