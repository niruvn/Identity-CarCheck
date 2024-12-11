package com.coreLibriaries;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

//Reads browser properties from ConfigReader, sets the timeout and returns the WebDriver
//TO DO Capabilities, profile etc..
public class GetWebDriver {
    public static WebDriver driver;

    public static WebDriver initializeDriver() {
        String browserName = ConfigReader.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("web-driver.chrome.driver", ConfigReader.getProperty("chromeDriverPath"));
            driver = new ChromeDriver(new ChromeOptions());

        } else if (browserName.equals("FireFox")) {
            System.setProperty("webdriver.gecko.driver", ConfigReader.getProperty("fireFoxDriverPath"));
            driver = new FirefoxDriver();
            //Add more browser options and capabilities
        } else { //default load FireFox browser
            System.setProperty("webdriver.gecko.driver", ConfigReader.getProperty("fireFoxDriverPath"));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(ConfigReader.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        return driver;
    }

}
