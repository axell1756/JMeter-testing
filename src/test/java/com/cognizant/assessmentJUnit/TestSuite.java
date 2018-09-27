package com.cognizant.assessmentJUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cognizant.assessmentJUnit.Const;

import com.relevantcodes.extentreports.ExtentReports;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CucumberTests.StackRunner.class,
	RESTAssuredTests.ApiTests.class
})
public class TestSuite {
	
	static public ExtentReports report = new ExtentReports(Const.REPORT_PATH + "assessment.html", true);

}