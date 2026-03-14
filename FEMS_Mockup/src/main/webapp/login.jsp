<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>F-EMS Login</title>
        <style>
            body {
                font-family: sans-serif;
                background: #e9ecef;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .login-card {
                background: white;
                padding: 30px;
                border-radius: 8px;
                width: 350px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            }
            input {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ddd;
                border-radius: 4px;
                box-sizing: border-box;
            }
            button {
                width: 100%;
                padding: 10px;
                background: #28a745;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }
            #error-msg {
                color: #dc3545;
                font-size: 14px;
                margin-bottom: 10px;
                display: none;
            }
        </style>
    </head>
    <body>

        <script>
            function validateLogin() {
                const user = document.getElementById('username').value;
                const pass = document.getElementById('password').value;
                const error = document.getElementById('error-msg');

                // Logic kiểm tra tài khoản cố định
                if (user === "admin" && pass === "12345") {
                    return true; // Cho phép chuyển sang profile.jsp
                } else {
                    error.style.display = 'block'; // Hiện lỗi "Invalid credentials"
                    return false; // Chặn chuyển trang để Selenium kiểm tra lỗi [cite: 160, 188]
                }
            }
        </script>
        <div class="login-card">

            <form action="profile.jsp" method="POST" onsubmit="return validateLogin()">
                <h2>F-EMS Login</h2>
                <div id="error-msg" style="color:red; display:none; margin-bottom:10px;">
                    Invalid username or password!
                </div>
                Tài khoản: <input type="text" id="username" name="user"> <br><br>
                Mật khẩu: <input type="password" id="password" name="pass"> <br><br>
                <button type="submit" id="btn-login">Login</button>
            </form>
        </div>
    </body>
</html>