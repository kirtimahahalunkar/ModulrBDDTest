package org.modulr.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    //for parallel execution
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /*
    initialize driver on basis of the browser value
     */
    public WebDriver init_driver(String browser)
    {
        System.out.println(" Executing Test Cases on "+browser+" Browser");

        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }else
        {
            System.out.println("Browser value is not correct");

        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {

        return tlDriver.get();
    }
}
