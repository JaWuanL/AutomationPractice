package components;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import ControlExtensions.DropdownList;

public class ManufacturerBlockComponent extends ComponentSuperClass {

	private By manufacturerDropdownListLocator = By.name("manufacturer_list");

	public ManufacturerBlockComponent(SearchContext searchContext, WebDriver driver) {
		super(searchContext, driver);
	}

	public DropdownList getManufacturerDropdownList() {
		return getControlExtensionFactory().getDropdownList(manufacturerDropdownListLocator );
	}
}
