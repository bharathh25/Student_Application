<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Pentagon Space - Application Form</title>
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
      text-size-adjust: 200px;
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

    span{
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
    <h2>Application form</h2>
    
    <% if (request.getAttribute("error")!=null) { %>             
    <h3 class="failure"> <%=request.getAttribute("error") %></h3>
    <%} %>

    <form action="signup" method="post">
      <label for="name">Enter your Name:</label>
      <input type="text" id="name" name="name">

      <label for="phone">Enter the Phone number:</label>
      <input type="text" id="phone" name="phone">

      <label for="email">Enter the Mail ID:</label>
      <input type="email" id="email" name="mail">

      <label for="branch">Enter the Branch:</label>
      <input type="text" id="branch" name="branch">

      <label for="location">Enter the Location:</label>
      <input type="text" id="location" name="loc">

      <label for="password">Enter the password:</label>
      <input type="password" id="password" name="password">

      <label for="confirm">Confirm the password:</label>
      <input type="password" id="confirm" name="confirm">

      <div class="form-footer">
        <button type="submit">Create account</button>
        <span>Already have an account? <a href="Login.jsp">Login</a></span>
      </div>
    </form>
  </div>
</body>
</html>
    