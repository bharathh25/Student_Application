<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Pentagon Space - Forgot Password</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      margin: 0;
      padding: 0;
    }

    .container {
      width: 500px;
      margin: 50px auto;
      background-color: #fff;
      padding: 30px 40px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
      text-align: center;
      color: #2c2c2c;
      margin-bottom: 0;
    }

    h2 {
      text-align: center;
      color: #4285F4;
      margin-top: 5px;
      margin-bottom: 25px;
    }

    form {
      display: grid;
      grid-template-columns: 180px 1fr;
      row-gap: 15px;
      column-gap: 15px;
      align-items: center;
    }

    label {
      text-align: right;
      font-weight: bold;
    }

    input {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    .form-footer {
      grid-column: span 2;
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-top: 20px;
    }

    button {
      background-color: #2e6dfb;
      color: white;
      padding: 8px 15px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      height: 50px;
      width: 200px;
      font-size: 16px;
      font-weight: bold;
    }

    button:hover {
      background-color: #174dc9;
    }

    a {
      color: #2e6dfb;
      text-decoration: none;
      font-size: 16px;
      font-weight: bold;
    }

    a:hover {
      text-decoration: underline;
    }

    span {
      font-size: 16px;
      font-weight: bold;
    }
    
    .failure{
    	text-align: center;
    	color: red;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Pentagon Space</h1><br>
    <h2>Forgot Password</h2>
    
    <% if(request.getAttribute("error")!=null){ %>
    <h3 class=failure><%=request.getAttribute("error") %></h3>
    <%} %>

    <form action="updatePassword" method="post">
      <label for="phone">Enter your Phone Number:</label>
      <input type="text" id="phone" name="phone" required>

      <label for="email">Enter your Mail ID:</label>
      <input type="email" id="email" name="mail" required>

      <label for="newpassword">Enter New Password:</label>
      <input type="password" id="newpassword" name="newpassword" required>

      <label for="confirmpassword">Confirm New Password:</label>
      <input type="password" id="confirmpassword" name="confirmpassword" required>

      <div class="form-footer">
        <button type="submit">Update Account</button>
        <span><a href="Login.jsp">Back to Login</a></span>
      </div>
    </form>
  </div>
</body>
</html>
    