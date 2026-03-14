package com.vananh.exercise1_seleniumbasic.tests;

import com.vananh.exercise1_seleniumbasic.pages.RegisterPage;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTest {
    @Test
    void testRegisterSuccessfully() {
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get("https://demoqa.com/automation-practice-form");
        
        registerPage.fillRegistrationForm("An", "Nguyen", "an@gmail.com", "0123456789");
        registerPage.submitForm();
        
    }
}