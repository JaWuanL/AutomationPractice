package ControlExtensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReactTableCell {
	
	private WebElement _mappedElement;
	private WebDriver _driver;

	public ReactTableCell(WebElement mappedElement, WebDriver driver) {
		_mappedElement = mappedElement;
		_driver = driver;
	}

	public String getValue() {
		return _mappedElement.getText();
	}
}
