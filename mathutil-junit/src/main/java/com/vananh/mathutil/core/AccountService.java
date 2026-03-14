package com.vananh.mathutil.core;

public class AccountService {

    public boolean registerAccount(String username, String password, String email) {
        // Kiểm tra username không được để trống
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        // Password phải lớn hơn 6 kí tự
        if (password == null || password.length() <= 6) {
            return false;
        }
        // Email phải hợp lệ
        if (!isValidEmail(email)) {
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email == null) return false;
        // Sử dụng Regex đơn giản để kiểm tra định dạng email
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }
}