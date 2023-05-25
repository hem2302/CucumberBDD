package step.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagebojects.LandingPage;
import utils.TestContextSetup;

//Every project should follow the single responsibility principle
//classes should be loosly coupled which means they should be able to enhanced in the future.
//factory design pattern to create objects on a single class.
public class LandingPageSetpDefinition {
	WebDriver driver;
	String landingPageProductName;
	String offerPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

// Dependency injection for global driver across all classes with the cucumberpicocontainer dependency
//Here textcontextsetup class is the class having the global driver and the instance assigned to all the classes using the constructor
	public LandingPageSetpDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("user is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^user searched with short name (.+) and extracted actual name of the product$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_the_product(String shortName)
			throws InterruptedException {

		// create object for landing page
		// using pageobject manager
		landingPage.SearchItem(shortName);
		Thread.sleep(5000);
		testContextSetup.landingPageProductName = landingPage.getTheProductName();
		
		System.out.println(testContextSetup.landingPageProductName + "product name is extracted from the homepage");
	}

	@Then("user added {string} of the selected product to the cart")
	public void Then_user_added_count_of_the_selected_product_to_the_cart(String quantity) throws InterruptedException {

		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();

	}

}
