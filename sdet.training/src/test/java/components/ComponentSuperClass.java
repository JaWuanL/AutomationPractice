package components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import framework.ControlExtensionFactory;

public abstract class ComponentSuperClass {

	private SearchContext searchContext;
	private WebDriver driver;

	public ComponentSuperClass(SearchContext searchContext, WebDriver driver) {
		this.searchContext = searchContext;
		this.driver = driver;
	}
	
	protected ControlExtensionFactory getControlExtensionFactory() {
		return new ControlExtensionFactory(searchContext, driver);
	}
}
