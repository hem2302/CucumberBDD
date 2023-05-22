package utils;

import org.openqa.selenium.WebDriver;

import pagebojects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;

	public TestContextSetup() {
		pageObjectManager = new PageObjectManager(driver);
	}
}
