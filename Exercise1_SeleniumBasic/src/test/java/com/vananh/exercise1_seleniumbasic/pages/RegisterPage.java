package com.vananh.exercise1_seleniumbasic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators cho các trường thông tin quan trọng
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']"); // Click vào Label [cite: 119]
    private By userNumber = By.id("userNumber");
    private By submitBtn = By.id("submit");

    public void fillRegistrationForm(String fName, String lName, String email, String phone) {
        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        click(genderMale);
        type(userNumber, phone);
    }

    public void submitForm() {
        clickByJS(submitBtn);
    }
}
