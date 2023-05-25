package step.definitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import pagebojects.CheckoutPage;
import pagebojects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	public TestContextSetup testContextSetup;
	public LandingPage landingPage;
	public CheckoutPage checkoutPage;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@And("^user proceeds to Checkout and validate the (.+) items in the cart page$")
	public void user_proceeds_to_Checkout_and_validate_the_items_in_the_cart_page(String name) {
checkoutPage.checkOutItems();
	}

	@And("verify user had ability enter promo code and place the order")
	public void verify_user_had_ability_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
	}
}
