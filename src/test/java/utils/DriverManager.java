package utils;


import dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static utils.PropertyUtils.getPropertyFromConfigFile;

//public class DriverManager {
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            // Initialize the WebDriver instance
//            System.setProperty("webdriver.chrome.driver", "C:/Users/Vlungu/IdeaProjects/ATF_Selenium/src/test/resources/driver/chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.get("https://shop.demoqa.com/my-account/");
//        }
//        return driver;
//    }


    public class DriverManager {
        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                // Initialize the WebDriver instance
                System.setProperty("webdriver.chrome.driver", getPropertyFromConfigFile("driverPath"));
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get("https://shop.demoqa.com/my-account/");
            }
            return driver;
        }


    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}





