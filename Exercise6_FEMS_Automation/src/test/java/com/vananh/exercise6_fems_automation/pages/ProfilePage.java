package com.vananh.exercise6_fems_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By nameInput = By.id("full-name");
    private By fileInput = By.id("avatar-input");
    private By saveBtn = By.id("btn-save");
    private By successMsg = By.id("update-success-msg");

    public void updateProfile(String name, String path) {
        type(nameInput, name);
        driver.findElement(fileInput).sendKeys(path);
        click(saveBtn);
    }

    public String getMessageText() {
        // successMsg là By.id("update-success-msg") đã khai báo ở trên
        return getText(successMsg);
    }
}
