package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,
features = {"FeatureFiles"},monochrome = true,
glue = {"stepDefination"},tags = ("@suppliers or @Customers"),
plugin = {"pretty","html:target/report/cucumber.html",
		"junit:target/report/cucumber.xml",
		"json:target/report/cucumber.json"})
public class AppTest extends AbstractTestNGCucumberTests{

}
