package org.modulr.appHooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.modulr.factory.DriverFactory;
import org.modulr.utility.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader config;
    Properties prop;

    @Before(order = 0)
    public void getProperties()
    {
        config = new ConfigReader();
        prop = config.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser()
    {
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(prop.getProperty("browser"));

    }

    @After(order = 0)
    public void quiteBrowser()
    {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            String screenshotName = scenario.getName().replaceAll(" ","_");
            byte[] sourcePath =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);
        }
    }

}
