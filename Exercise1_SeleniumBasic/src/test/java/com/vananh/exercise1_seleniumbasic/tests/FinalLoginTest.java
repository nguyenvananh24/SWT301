package com.vananh.exercise1_seleniumbasic.tests;

import com.vananh.exercise1_seleniumbasic.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class FinalLoginTest extends BaseTest {
    @Test
    void testLoginWithPOM() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage.login("tomsmith", "SuperSecretPassword!");
        // Bạn có thể thêm Assert ở đây để kiểm tra kết quả [cite: 325]
    }
}