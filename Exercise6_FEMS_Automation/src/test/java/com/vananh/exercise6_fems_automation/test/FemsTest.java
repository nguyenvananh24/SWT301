package com.vananh.exercise6_fems_automation.test;
import com.vananh.exercise6_fems_automation.pages.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FemsTest extends BaseTest {

    @Order(1)
    @ParameterizedTest(name = "Test Login - {0}")
    @CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 1)
    void testLogin(String user, String pass, String expected) {
        test = extent.createTest("Kiểm thử Đăng nhập: " + user);
        driver.get("http://localhost:8080/FEMS_Mockup/login.jsp");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);

        if (expected.equals("success")) {
            assertTrue(driver.getCurrentUrl().contains("profile.jsp"));
            test.pass("Đăng nhập thành công và chuyển hướng đúng");
        } else {
            assertTrue(driver.getPageSource().contains("Invalid"));
            test.pass("Hệ thống hiển thị thông báo lỗi đúng mong đợi");
        }
    }

    @Order(2)
    @Test
    void testUpdateProfileAndUpload() {
        test = extent.createTest("Kiểm thử Cập nhật Profile và Upload ảnh");
        driver.get("http://localhost:8080/FEMS_Mockup/profile.jsp");

        ProfilePage profilePage = new ProfilePage(driver);
        // Lưu ý: Đảm bảo đường dẫn file ảnh này có thật trên máy bạn
        String imgPath = "C:\\Users\\Anh Van Nguyen\\Downloads\\avatar.jpg"; 
        profilePage.updateProfile("Nguyen Van Anh", imgPath);

        assertTrue(profilePage.getMessageText().contains("thành công"));
        test.pass("Cập nhật profile và upload ảnh thành công");
    }
}