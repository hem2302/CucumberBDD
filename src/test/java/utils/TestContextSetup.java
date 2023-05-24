package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pagebojects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	public BaseTest baseTest;

	public TestContextSetup() throws IOException {
		baseTest = new BaseTest();
		pageObjectManager = new PageObjectManager(baseTest.WebDriverManager());
		genericUtils = new GenericUtils(baseTest.WebDriverManager());

	}
}
