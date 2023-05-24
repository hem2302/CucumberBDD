package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;

	public GenericUtils(WebDriver driver) {

		this.driver = driver;
	}

	public void switchWindowToChild() {
		String parentWindow = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		for (String child : handle) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
	}
}
