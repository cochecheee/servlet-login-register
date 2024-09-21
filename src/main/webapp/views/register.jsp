<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.container {
	width: 400px;
	padding: 20px;
	background-color: white;
	margin: 0 auto;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
}

input[type="text"], input[type="email"], input[type="password"], input[type="tel"]
	{
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

button {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Register</h2>
		<form action="/exercise01/register" method="post">
			<label for="username">Username</label> <input type="text"
				id="username" name="username" placeholder="Enter your username"
				required> <label for="fullname">Full Name</label> <input
				type="text" id="fullname" name="fullname"
				placeholder="Enter your full name" required> <label
				for="email">Email</label> <input type="email" id="email"
				name="email" placeholder="Enter your email" required> <label
				for="phone">Phone Number</label> <input type="tel" id="phone"
				name="phone" placeholder="Enter your phone number" required>

			<label for="password">Password</label> <input type="password"
				id="password" name="password" placeholder="Enter your password"
				required> <label for="repassword">Re-enter Password</label>
			<input type="password" id="repassword" name="repassword"
				placeholder="Re-enter your password" required>

			<button type="submit">Register</button>
		</form>
	</div>

</body>
</html>