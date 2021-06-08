import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import foundation.AutomationPracticeTestsSuperClass;
import framework.Helpers;

public class FunctionalTests extends AutomationPracticeTestsSuperClass {

	@Test
	public void canFilterSearchResultsByFashionManufacturer() {

		String searchCriteria = "shirt";
		String expectedManufacturer = "Fashion Manufacturer";

		String actualManufacturer = new HomePage(driver, baseUrl)
				.enterSearchCriteria(searchCriteria)
				.clickSearchButton()
				.selectManufacturer(expectedManufacturer)
				.getPageHeadingText();

		assertEquals(actualManufacturer, expectedManufacturer, "results should be filtered by selected manufacturer.");		
	}


	@Test (dataProvider = "products")
	public void canSearchForProduct(String productName) {

		String displayedHeadingText = new HomePage(driver, baseUrl)
				.enterSearchCriteria(productName)
				.clickSearchButton()
				.getPageHeadingText();
		
		String displayedProductName = Helpers.getTextBetween(displayedHeadingText, "\"", "\"");
		
		assertEquals(displayedProductName, productName, "heading text after searching should product name search for.");		
	}

	@DataProvider(name = "products")	
	private String[] getProducts() {
		return new String[] { "DRESSES", "SHIRTS", "BLOUSES" };
	}
}
