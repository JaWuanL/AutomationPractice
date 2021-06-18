package components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductTiles extends ComponentSuperClass {

	private By listItemsLocator = By.tagName("li");

	public ProductTiles(SearchContext searchContext, WebDriver driver) {
		super(searchContext, driver);
	}

	public void addProductToCart(String productName) {
		
		List<ProductTile> tiles = getProductTiles();
		
		for(ProductTile tile : tiles) {

			tile.setFocus();

			String name = tile.getProductName();			
			
			if(name.equals(productName)) {
				tile.addToCart();
				
				return;
			}
		}
		
		throw new RuntimeException(new Exception("No product tile for product '"+productName+"' was found"));
	}
	
	public List<ProductTile> getProductTiles(){
		List<WebElement> elements = searchContext.findElements(listItemsLocator );
		
		ArrayList<ProductTile> productTiles = new ArrayList<ProductTile>();
		
		for(WebElement element : elements) {
			ProductTile tile = new ProductTile(element, driver);
			
			productTiles.add(tile);
		}
		
		return productTiles;
	}
}
