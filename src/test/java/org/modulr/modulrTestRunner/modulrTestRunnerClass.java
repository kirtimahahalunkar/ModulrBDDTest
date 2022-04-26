package org.modulr.modulrTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/org/modulr/features"},
        glue={"org/modulr/stepDefinitions","org/modulr/appHooks"},
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        plugin = {"pretty", "junit:target/JUNITReports/report.xml",
                "html:target/HTMLReports.html",
               // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)
public class modulrTestRunnerClass {
}


