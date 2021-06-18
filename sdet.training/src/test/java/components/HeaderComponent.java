package components;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends ComponentSuperClass {
	private By searchTextboxLocator = By.id("search_query_top");
	private By searchButtonLocator = By.name("submit_search");

	public HeaderComponent(SearchContext searchContext, WebDriver driver) {
		super(searchContext, driver);
	}

	public HeaderComponent enterSearchCriteria(String searchCriteria) {
		getControlExtensionFactory().getTextbox(searchTextboxLocator).setValue(searchCriteria);
		
		return this;
	}

	public HeaderComponent clickSearchButton() {
		getControlExtensionFactory().getButton(searchButtonLocator).click();
		
		return this;	
	}
}
