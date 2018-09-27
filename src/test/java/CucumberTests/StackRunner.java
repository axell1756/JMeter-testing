package CucumberTests;


import org.junit.runner.RunWith;

import com.cognizant.assessmentJUnit.Const;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = Const.FEATURES_PATH)
public class StackRunner {
	
}
