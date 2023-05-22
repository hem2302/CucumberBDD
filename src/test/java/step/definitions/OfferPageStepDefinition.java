package step.definitions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pagebojects.LandingPage;
import pagebojects.OffersPage;
import pagebojects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	WebDriver driver;
	String offersPageProductName;
	String landingPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();

		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();// create object for offers page
																					// using pageobject manager
		offersPage.OffersPageSearchItem(shortName);
		Thread.sleep(5000);
		offersPageProductName = offersPage.OffersPageSearchGetItemText().trim();

	}

	public void switchToOffersPage() {
		pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();// create object for landing page
																						// using pageobject manager
		landingPage.clickTopDeals();
		String parentWindow = testContextSetup.driver.getWindowHandle();
		Set<String> handle = testContextSetup.driver.getWindowHandles();
		for (String child : handle) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				testContextSetup.driver.switchTo().window(child);
			}
		}
	}

	@And("validate product name in offers page matches with the landing page")
	public void validate_product_name_in_offers_page_matches_with_the_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offersPageProductName);
	}

}
