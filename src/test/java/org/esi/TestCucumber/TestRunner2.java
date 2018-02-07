package org.esi.TestCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features",
		glue="stepDefinition",
		plugin= {"html:target/cucumber-html-report","junit:target/test-results.xml"}
		)
public class TestRunner2 {

}
