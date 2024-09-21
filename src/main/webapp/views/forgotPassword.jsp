<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.forgot-password-container {
	max-width: 400px;
	width: 100%;
	padding: 20px;
	background-color: #ffffff;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.forgot-password-container h1 {
	text-align: center;
	margin-bottom: 20px;
}
</style>
</head>
<body>

	<div class="forgot-password-container">
		<h1>Forgot Password</h1>
		<form id="forgotPasswordForm" action="/helloworld/forgotPassword" method="post">
			<div class="mb-3">
				<label for="email" class="form-label">Username</label> <input
					type="text" class="form-control" name="username"
					placeholder="Enter your username" required>
			</div>
			<div class="mb-3">
				<label for="newPassword" class="form-label">New Password</label> <input
					type="password" class="form-control" name="password"
					placeholder="Enter new password" required>
			</div>
			<div class="mb-3">
				<label for="confirmPassword" class="form-label">Confirm
					Password</label> <input type="password" class="form-control"
					name ="confirmPassword" placeholder="Confirm new password" required>
			</div>
			<button type="submit" class="btn btn-primary w-100">Submit</button>
		</form>
		<p class="text-center mt-3">
			<a href="/helloworld/login">Back to Login</a>
		</p>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js">
    document.getElementById('forgotPasswordForm').addEventListener('submit', function(event) {
        event.preventDefault();  // Ngăn chặn việc gửi form mặc định

        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (newPassword !== confirmPassword) {
            alert('Passwords do not match');
            return;
        }
	</script>
</body>
</html>