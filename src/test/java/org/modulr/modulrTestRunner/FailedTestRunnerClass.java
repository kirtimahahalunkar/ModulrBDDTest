package org.modulr.modulrTestRunner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features={"@target/FailedRerun.txt"},
        //features={"src/test/resources/org/modulr/features"},
        glue={"org/modulr/stepDefinitions","org/modulr/appHooks"},
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        plugin = {"pretty",
                "html:target/HTMLReports.html",
                "rerun:target/FailedRerun.txt"
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class FailedTestRunnerClass {
}


