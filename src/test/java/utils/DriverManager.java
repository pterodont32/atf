package utils;


import dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static utils.PropertyUtils.getPropertyFromConfigFile;

    public class DriverManager {
        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                // Initialize the WebDriver instance
                System.setProperty("webdriver.chrome.driver", getPropertyFromConfigFile("driverPath"));
                driver = new ChromeDriver();
                driver.manage().window().maximize();
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(getPropertyFromConfigFile("urlMyAccountPage"));
            }
            return driver;
        }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}





