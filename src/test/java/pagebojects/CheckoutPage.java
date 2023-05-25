package pagebojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cartBagIcon = By.cssSelector("img[alt=Cart]");
	By cartCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoApplyButton = By.cssSelector(".promobtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

	public void checkOutItems() {
		driver.findElement(cartBagIcon).click();
		driver.findElement(cartCheckoutButton).click();

	}

	public boolean verifyPromoButton() {
		return driver.findElement(promoApplyButton).isDisplayed();

	}

	public boolean verifyPlaceOrderButton() {
		return driver.findElement(placeOrder).isDisplayed();
	}

}
