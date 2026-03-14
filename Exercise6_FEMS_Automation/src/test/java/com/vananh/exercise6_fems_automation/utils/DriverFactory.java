package com.vananh.exercise6_fems_automation.utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup(); // Tự động khớp bản 145
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); 
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}