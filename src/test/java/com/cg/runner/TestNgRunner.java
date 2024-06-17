package com.cg.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/resources/features/Login_tests.feature",
glue = { "com.cg.stepdef", "com.cg.hooks" },
dryRun = false,
monochrome= true,
plugin = {"pretty", "html:target/report.html"})

public class TestNgRunner extends AbstractTestNGCucumberTests {	
	
}
