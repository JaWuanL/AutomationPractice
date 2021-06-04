package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import components.HeaderComponent;
import components.ManufacturerBlockComponent;
import framework.PageSuperClass;

public class HomePage extends PageSuperClass {
	
	@FindBy(how=How.ID, using="header")
	private WebElement headerElement;
	
	@FindBy(how=How.ID, using="header")
	private WebElement manufacturerBlockElement;

	@FindBy(how=How.CSS, using="h1[class='page-heading product-listing']")
	private WebElement headingElement;

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HomePage enterSearchCriteria(String searchCriteria) {
		new HeaderComponent(headerElement, driver)
			.enterSearchCriteria(searchCriteria);;
		
		return this;
	}

	public HomePage clickSearchButton() {
		new HeaderComponent(headerElement, driver)
		.clickSearchButton();

		return this;
	}
	
	public HomePage selectManufacturer(String manufacturer) {
		new ManufacturerBlockComponent(manufacturerBlockElement, driver)
			.getManufacturerDropdownList().select(manufacturer);
		
		return this;
	}

	public String getPageHeadingText() {
		return headingElement.getText();
	}
}
