package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/FBregister.feature",
glue={"stepDefinitions"},
monochrome=true,
plugin={"pretty", "html:target/HTMLreports/htmlReport.html",
		"json:target/JSONreports/jsonReport.json",
		"junit:target/JUNITreports/xmlReport.xml"}/*
tags="@smoketest*/)

public class FBrunner {}
