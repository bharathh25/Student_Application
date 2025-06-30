<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.student.dto.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Pentagon Space - Reset Password</title>
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

    h1, h2 {
      text-align: center;
      margin-bottom: 10px;
    }

    h2 {
      color: #4285F4;
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
      margin-top: 20px;
    }

    .form-footer button {
      background-color: #2e6dfb;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
      font-weight: bold;
      width: 48%;
    }

    .form-footer button:hover {
      background-color: #174dc9;
    }

    .message {
      text-align: center;
      font-weight: bold;
      margin-bottom: 20px;
    }

    .error {
      color: red;
    }

    .success {
      color: green;
    }
  </style>
</head>
<body>

<%
  Student s = (Student) session.getAttribute("Student");
%>

<div class="container">
  <h1>Pentagon Space</h1>
  <h2>Reset Your Password</h2>

  <% if (request.getAttribute("error") != null) { %>
    <div class="message error"><%= request.getAttribute("error") %></div>
  <% } else if (request.getAttribute("success") != null) { %>
    <div class="message success"><%= request.getAttribute("success") %></div>
  <% } %>

  <form action="resetPassword" method="post">
    <label for="phone">Phone Number:</label>
    <input type="text" id="phone" name="phone" 
           value="<%= (s != null && s.getPhone() != 0) ? s.getPhone() : "" %>" required>

    <label for="mail">Email ID:</label>
    <input type="email" id="mail" name="mail"
           value="<%= (s != null && s.getMail() != null) ? s.getMail() : "" %>" required>

    <label for="newpassword">New Password:</label>
    <input type="password" id="newpassword" name="newpassword" >

    <label for="confirmpassword">Confirm New Password:</label>
    <input type="password" id="confirmpassword" name="confirmpassword" >

    <div class="form-footer">
      <button type="submit">Reset Password</button>
      <button type="button" onclick="window.location.href='Dashboard.jsp?msg=notChanged'">Back to Dashboard</button>
      <!-- Here msg is key, and notChanged is value  -->
    </div>
  </form>
</div>

</body>
</html>
