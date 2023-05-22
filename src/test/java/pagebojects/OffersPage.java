package pagebojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchItem = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");

	public void OffersPageSearchItem(String name) {
		driver.findElement(searchItem).sendKeys(name);
	}

	public String OffersPageSearchGetItemText() {
		return driver.findElement(productName).getText();
	}
}