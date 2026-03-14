package com.vananh.exercise6_fems_automation.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vananh.exercise6_fems_automation.utils.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test; // Phải có static để dùng chung

    @BeforeAll
    public static void setUpBase() {
        // Tạo file báo cáo trong thư mục target
        ExtentSparkReporter spark = new ExtentSparkReporter("target/TestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDownBase() {
        if (driver != null) driver.quit();
        if (extent != null) extent.flush(); // Xuất báo cáo
    }
}