package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * @author ashok
 * @see this class used to run all the feature files in OMR Branch API
 *      Automation project
 * @since 02-06-2023
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Login or @State or @City or @Address or @Product", features = "src\\test\\resources", glue = "com.step", plugin = {
		"pretty", "json:target\\reportOutput.json" }, dryRun = false)

public class TestRunnerClass extends BaseClass {

	@AfterClass
	public static void report() throws FileNotFoundException, IOException {

		Reporting.generateReport(getProjectPath() + getPropertyFileValue("jsonPath"));
	}

}