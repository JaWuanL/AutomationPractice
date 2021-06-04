import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Pages.HomePage;
import foundation.AutomationPracticeTestsSuperClass;

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
}
