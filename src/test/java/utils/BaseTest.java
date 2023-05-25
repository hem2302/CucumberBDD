package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

	public WebDriver driver;
	public String url;
	public String browserProperties;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//globalproperties.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		browserProperties = prop.getProperty("browser");
		String mavenBrowser = System.getProperty("browser");
		String browser = mavenBrowser != null ? mavenBrowser : browserProperties;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;

	}
}
