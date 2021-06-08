package components;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductTile extends ComponentSuperClass {

	private By productNameLocator = By.cssSelector("h5[itemprop='name']");
	private By addToCartButtonLocator = By.xpath(".//a[contains(@class,'ajax_add_to_cart_button')]");
	
	public ProductTile(SearchContext searchContext, WebDriver driver) {
		super(searchContext, driver);
	}

	public String getProductName() {
		WebElement element = searchContext.findElement(productNameLocator);
		
		return element.getText();
	}

	public void addToCart() {
		WebElement element = searchContext.findElement(addToCartButtonLocator );
		
		element.click();		
	}

	public void setFocus() {
		new Actions(driver)
			.moveToElement((WebElement) searchContext)
			.perform();	
	}
}
