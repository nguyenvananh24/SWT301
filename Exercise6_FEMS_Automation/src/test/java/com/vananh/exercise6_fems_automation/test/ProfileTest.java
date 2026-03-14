package com.vananh.exercise6_fems_automation.test;

import com.vananh.exercise6_fems_automation.pages.LoginPage;
import com.vananh.exercise6_fems_automation.pages.ProfilePage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(2)
public class ProfileTest extends BaseTest {
    
    @Test
    @DisplayName("Kiểm thử chức năng Cập nhật thông tin cá nhân và Upload ảnh")
    void testUpdateProfileAndUpload() {
        // 1. Phải đăng nhập trước để vào được trang profile
        driver.get("http://localhost:8080/FEMS_Mockup/login.jsp"); // Thay bằng link F-EMS của bạn
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "12345");

        // 2. Điều hướng tới trang Profile
        driver.get("http://localhost:8080/FEMS_Mockup/profile.jsp");
        ProfilePage profilePage = new ProfilePage(driver);

        // 3. Thực hiện hành động (Sử dụng đường dẫn file thật trên máy bạn)
        String absolutePath = "C:\\Users\\Anh Van Nguyen\\Downloads\\avatar.jpg"; 
        profilePage.updateProfile("Nguyen Van Anh", absolutePath);

        // 4. Kiểm chứng kết quả [cite: 182, 183]
        assertTrue(profilePage.getMessageText().contains("thành công"));
    }
}