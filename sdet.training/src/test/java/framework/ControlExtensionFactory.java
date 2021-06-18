package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controlExtensions.Button;
import controlExtensions.DropdownList;
import controlExtensions.Textbox;

public class ControlExtensionFactory {

	private SearchContext searchContext;
	private WebDriver driver;

	public ControlExtensionFactory(SearchContext searchContext, WebDriver driver) {
		this.searchContext = searchContext;
		this.driver = driver;
	}

	public Button getButton(By locator) {
		return new Button(findElement(locator), driver);		
	}

	public DropdownList getDropdownList(By locator) {
		return new DropdownList(findElement(locator), driver);		
	}

	public Textbox getTextbox(By locator) {
		return new Textbox(findElement(locator), driver);		
	}
	
	private WebElement findElement(By locator) {
		return searchContext.findElement(locator);
	}
}
