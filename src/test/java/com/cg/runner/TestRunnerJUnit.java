package com.cg.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Login_tests.feature",
glue = { "com.cg.stepdef", "com.cg.hooks" },
dryRun = false,
monochrome= true,
plugin = {"pretty", "html:target/report.html"})

public class TestRunnerJUnit {
}
