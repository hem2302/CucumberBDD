package pagebojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
//
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDealsLink = By.linkText("Top Deals");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");

	public void SearchItem(String name) {
		driver.findElement(search).sendKeys(name);

	}

	public void incrementQuantity(int quantity) {
		for (int i = 1; i <= quantity - 1; i++) {
			driver.findElement(increment).click();
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}

	public void getSearchItem() {
		driver.findElement(search).getText();
	}

	public String getTheProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}

	public void clickTopDeals() {
		driver.findElement(topDealsLink).click();
	}

	public String getTitleLandingPage() {
		return driver.getTitle();
	}
}