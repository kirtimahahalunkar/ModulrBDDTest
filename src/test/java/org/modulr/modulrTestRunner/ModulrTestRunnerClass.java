package org.modulr.modulrTestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features/"},
        glue={"org/modulr/stepDefinitions","org/modulr/appHooks"},
        plugin = {"pretty",
                "html:target/HTMLReports.html",
                "timeline:test-output-thread/",
                "rerun:target/FailedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class ModulrTestRunnerClass {
}


