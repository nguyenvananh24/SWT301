<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <style>
        body { font-family: sans-serif; padding: 50px; background: #f8f9fa; }
        .profile-container { max-width: 500px; margin: auto; background: white; padding: 25px; border-radius: 10px; border-top: 5px solid #007bff; }
        input[type="text"] { width: 100%; padding: 8px; margin-bottom: 15px; }
        #update-success-msg { background: #d4edda; color: #155724; padding: 15px; border-radius: 5px; margin-top: 20px; display: none; }
    </style>
</head>
<body>
    <div class="profile-container">
        <h2>Cấu hình thông tin cá nhân</h2>
        <form id="profile-form">
            Họ và tên: <input type="text" id="full-name" name="fname" value="Sinh viên FPT"> <br>
            Ảnh đại diện: <br>
            <input type="file" id="avatar-input" name="file" style="margin: 15px 0;"> <br>
            <button type="button" id="btn-save" style="padding: 10px 20px; background: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">
                Lưu thay đổi
            </button>
        </form>

        <div id="update-success-msg">
            <strong>Thành công!</strong> Dữ liệu đã được cập nhật vào hệ thống.
        </div>
    </div>

 <script>
    document.getElementById('btn-save').onclick = function() {
        const name = document.getElementById('full-name').value;
        const file = document.getElementById('avatar-input').value;
        const success = document.getElementById('update-success-msg');
        
        if (name.trim() !== "" && file !== "") {
            success.style.display = 'block'; // Chỉ hiện khi đủ dữ liệu [cite: 156, 221]
            success.style.color = "green";
            success.innerHTML = "Cập nhật thành công!";
        } else {
            success.style.display = 'block';
            success.style.color = "red";
            success.innerHTML = "Vui lòng nhập tên và chọn ảnh!"; // Lỗi cho Negative Test [cite: 185, 188]
        }
    };
</script>
</body>
</html>