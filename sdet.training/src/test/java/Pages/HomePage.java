package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import components.HeaderComponent;
import components.ManufacturerBlockComponent;
import components.ProductTiles;
import framework.PageSuperClass;

public class HomePage extends PageSuperClass {
	
	@FindBy(how=How.ID, using="header")
	private WebElement headerElement;
	
	@FindBy(how=How.ID, using="manufacturers_block_left")
	private WebElement manufacturerBlockElement;

	@FindBy(how=How.XPATH, using=".//h1[contains(@class, 'page-heading')]")
	private WebElement headingElement;

	@FindBy(how=How.CSS, using="ul[id='homefeatured']")
	private WebElement productTileElement;

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

	public HomePage addProductToCart(String productName) {
		new ProductTiles(productTileElement, driver)
		.addProductToCart(productName);
		
		return this;
	}

	public CartPage directNavigateToCart() {
		return new CartPage(driver, baseUrl).navigate();
	}
}
