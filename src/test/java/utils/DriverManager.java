package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize the WebDriver instance
            System.setProperty("webdriver.chrome.driver", "C:/Users/Vlungu/IdeaProjects/ATF_Selenium/src/test/resources/driver/chromedriver.exe");
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




//
//package utils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.util.concurrent.TimeUnit;
//import dataProviders.ConfigFileReader;
//
//public class DriverManager {
//    private static WebDriver driver;
//    static ConfigFileReader configFileReader;
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            // Initialize the WebDriver instance
//            System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.get("https://shop.demoqa.com/my-account/");
//        }
//        return driver;
//    }
//}




// info     https://www.toolsqa.com/selenium-cucumber-framework/read-configurations-from-property-file/