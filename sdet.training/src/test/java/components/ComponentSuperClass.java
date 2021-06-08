package components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import framework.ControlExtensionFactory;

public abstract class ComponentSuperClass {

	protected SearchContext searchContext;
	protected WebDriver driver;

	public ComponentSuperClass(SearchContext searchContext, WebDriver driver) {
		this.searchContext = searchContext;
		this.driver = driver;
	}
	
	protected ControlExtensionFactory getControlExtensionFactory() {
		return new ControlExtensionFactory(searchContext, driver);
	}
}
