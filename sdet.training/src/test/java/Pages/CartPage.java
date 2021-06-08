package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageSuperClass;

public class CartPage extends PageSuperClass {

	private String pageUrl = "/index.php?controller=order";

	protected CartPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public CartPage navigate() {
		super.navigate(pageUrl);
		
		return this;
	}

	public List<String> getCartItems() {
		List<WebElement> elements = driver.findElements(By.cssSelector("td.cart_description p.product-name"));
		
		return getTextFromElements(elements);
	}
}
