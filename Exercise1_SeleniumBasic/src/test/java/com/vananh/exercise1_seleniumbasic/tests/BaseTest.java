package com.vananh.exercise1_seleniumbasic.tests;

import com.vananh.exercise1_seleniumbasic.utils.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}