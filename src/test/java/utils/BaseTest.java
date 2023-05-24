package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

	public WebDriver driver;
	public String url;
	public String browser;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//globalproperties.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			if (driver == null) {
				driver = new ChromeDriver();
				driver.get(url);
			}
		} else if (browser.equals("firefox")) {
			if (driver == null) {
				driver = new FirefoxDriver();
				driver.get(url);
			}
		}

		else if (browser.equals("edge")) {
			if (driver == null) {
				driver = new EdgeDriver();
				driver.get(url);
			}
		}
		return driver;

	}
}
