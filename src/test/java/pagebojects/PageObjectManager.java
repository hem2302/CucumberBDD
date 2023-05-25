package pagebojects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkOutPage;
	WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;

	}

	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}

	public CheckoutPage getCheckoutPage() {
		checkOutPage = new CheckoutPage(driver);
		return checkOutPage;

	}
}
