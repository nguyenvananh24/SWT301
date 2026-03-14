package com.vananh.exercise1_seleniumbasic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Khai báo các địa chỉ nút bấm [cite: 295-296]
    private By userField = By.id("username");
    private By passField = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public void login(String user, String pass) {
        type(userField, user);
        type(passField, pass);
        click(loginBtn);
    }
    // Trong file LoginPage.java [cite: 297]

    public void navigate() {
        navigateTo("https://the-internet.herokuapp.com/login");
    }
}
