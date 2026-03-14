package com.vananh.exercise1_seleniumbasic.utils;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
public static WebDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<>();

    options.setExperimentalOption("prefs", prefs);
    options.addArguments("--incognito");
    return new ChromeDriver(options);
}
}