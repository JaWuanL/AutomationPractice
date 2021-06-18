package cucumber;

import static org.testng.Assert.assertEquals;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import foundation.AutomationPracticeTestsSuperClass;
import pages.HomePage;
import cucumber.api.java.en.Then;

public class cartStepDefinitions extends AutomationPracticeTestsSuperClass {
	private HomePage _homePage;

	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		_homePage = new HomePage(driver, baseUrl);
	}

	@When("^I add the product (.*?) to the cart$")
	public void i_add_a_product_to_the_cart(String product) throws Throwable {
		_homePage.addProductToCart(product);
	}

	@Then("^The product (.*?) is added to the cart$")
	public void the_product_is_added_to_the_cart(String product) throws Throwable {
	    List<String> cartItems = _homePage
	    	.directNavigateToCart()
	    	.getCartItems();
	    
		assertEquals(cartItems.get(0), product);
	}
}
