package com.vananh.exercise1_seleniumbasic.guru99;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99Test {

    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";

    @BeforeAll
    public static void setUpClass() {
        // chuẩn bị value cho các biến , khởi động trình duyêt
        System.setProperty("webdriver.chrom.driver", driverPath);
        myBrowser = new ChromeDriver();
        myBrowser.get("https://demo.guru99.com/V4/"); // duyệt trang trên object vừa new
        myBrowser.manage().window().maximize();
    }

    @Test
    public void testLoginGivenRightAccountSaysHelloUserName() throws InterruptedException {

        String userName = "mngr655206";
        String pass = "yjYjYrU";
        myBrowser.get("https://demo.guru99.com/V4/"); // duyệt trang trên object vừa new

        //tìm thẻ username và password qua:
        //CSS Selector, JQuery, xPath, name, id, class tuỳ
        //chính là 1 dạng câu query/SQL áp dụng cho tìm data thẻ phía sau trình duyệt
        //xPath, CSS Selector ~~~ SQL
        //trang Web/browser ~~~ CSDL
        //đưa câu query xPath cho myBrowser, tìm thẻ giùm tui giống F12, Ctrl-F
        //nếu tìm thấy thẻ, thì đó là 1 object đc trả về, thuộc class WebElement
        WebElement userTag = myBrowser.findElement(By.xpath("(//input[@name='uid'])[1]"));
        userTag.sendKeys(userName);// gõ username vào

        WebElement passTag = myBrowser.findElement(By.xpath("(//input[@name='password'])[1]"));
        passTag.sendKeys(pass);// gõ pass vào

        WebElement loginTag = myBrowser.findElement(By.xpath("(//input[@name='btnLogin'])[1]"));
        loginTag.click();// click login

        Thread.sleep(3000);//cần chờ chuyển trang xong
//do mạng, do kĩ thuật Front-end nhanh hay chậm
//khi render ra trang web mới
//ép code mình dừng/chờ/wait/dể dồng bộ
//tốc độ render ra trang mới. Tìm ngay tag
//ở trang mới 99% Exception
//do tìm thẻ mới ở trang cũ, trang mới chưa kịp render
//WAIT KHI CHUYEN TRANG !!!
        WebElement helloTag = myBrowser.findElement(By.xpath("(//td[normalize-space()='Manger Id : mngr655206'])[1]"));
// lấy được cái <td> chứa xin chào
        System.out.println("Hello Msg after login successfully: " + helloTag.getText());

        String actualHelloMsg = helloTag.getText();
        assertEquals("Manger Id : " + userName, actualHelloMsg);
        Thread.sleep(5000);

    }

    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit();// dọn dẹp rác, undo khi @Test đã chạy, đã làm thay đổi hiện trạng nào đó
        //ví dụ DB có rác do chạy test CRUD
    }
}
