import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Pages.HomePage;
import framework.TestSuperClass;

public class FunctionalTests extends TestSuperClass {

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
}
