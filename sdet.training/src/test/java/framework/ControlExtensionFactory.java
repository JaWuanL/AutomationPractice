package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ControlExtensionFactory {

	private WebDriver _driver;

	public ControlExtensionFactory(SearchContext searchContext, WebDriver driver) {
		_driver = driver;
	}

	public Button getButton(By locator) {
		return new Button(findElement(locator), _driver);		
	}

	public DropdownList getDropdownList(By locator) {
		return new DropdownList(findElement(locator), _driver);		
	}

	public Textbox getTextbox(By locator) {
		return new Textbox(findElement(locator), _driver);		
	}
	
	private WebElement findElement(By locator) {
		return _driver.findElement(locator);
	}
}
