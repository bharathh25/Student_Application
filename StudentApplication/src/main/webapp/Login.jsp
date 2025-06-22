<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Pentagon Space - Login</title>
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
      justify-content: center;
      margin-top: 20px;
    }

    .form-footer button {
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

    .form-footer button:hover {
      background-color: #174dc9;
    }

    .extra-links {
      grid-column: span 2;
      text-align: center;
      margin-top: 15px;
    }

    a {
      color: #2e6dfb;
      text-decoration: none;
      font-size: 16px;
      font-weight: bold;
      display: block;
      margin-top: 5px;
    }

    a:hover {
      text-decoration: underline;
    }
    .success{
		text-align: center;
         color: green;    
    }
    
    .error{
		text-align: center;
         color: red;    
    }
    
  </style>
</head>
<body>
  <div class="container">
    <h1>Pentagon Space</h1><br>
    <h2>Login Form</h2>
    
    <% if (request.getAttribute("success")!=null) { %>
    <h3 class="success"> <%=request.getAttribute("success") %></h3>
    <%} %>
    
    <% if (request.getAttribute("error")!=null) { %>
    <h3 class="error"> <%=request.getAttribute("error") %></h3>
    <%} %>
    
  	<% if (request.getAttribute("LogOutsuccess") != null) { %>
  <h3 style="color:green; text-align:center;"><%= request.getAttribute("LogOutsuccess") %></h3>
<% } %>
  	
    

    <form action="login" method="post">
      <label for="email">Enter your Mail ID:</label>
      <input type="email" id="email" name="mail" required>

      <label for="password">Enter your Password:</label>
      <input type="password" id="password" name="password" required>

      <div class="form-footer">
        <button type="submit">Login</button>
      </div>

      <div class="extra-links">
      <span>Don't have an account?<a href="Signup.jsp">Signup</a></span>
        <span><a href="ForgotPassword.jsp">Forgot Password?</a></span>
      </div>
    </form>
  </div>
</body>
</html>

    