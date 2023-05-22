package test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/featurefiles/SearchProduct.feature", glue = "step.definitions",
dryRun = false, monochrome = true, plugin = {"pretty", "html:reports/webreport.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
