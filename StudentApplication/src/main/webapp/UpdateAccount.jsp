<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.student.dto.Student" %>

    
   <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Pentagon Space - Update Account</title>
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

    input, select {
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
      width: 48%;
      font-size: 16px;
      font-weight: bold;
    }

    .form-footer button:hover {
      background-color: #174dc9;
    }

    .success {
      text-align: center;
      color: green;
    }

    .error {
      text-align: center;
      color: red;
    }
    
    
  </style>
</head>
<body>

<%Student user=(Student)session.getAttribute("Student");
  if(user!=null){%>


  <div class="container">
    <h1>Pentagon Space</h1><br>
    <h2>Update Account</h2>
    
    <%if(request.getAttribute("error")!=null){ %>
    <h3 class="error"><%=request.getAttribute("error")%></h3>
    <%} %>
    
   

    <!-- Display success or error message if needed -->
    <!-- <h3 class="success">Account updated successfully!</h3> -->
    <!-- <h3 class="error">Failed to update account. Please try again.</h3> -->

    <form action="updateAccount" method="post">
      <label for="name">Full Name:</label>
      <input type="text" id="name" name="name" value="<%= (user.getName() != null) ? user.getName() : ""%>">

      <label for="phone">Phone Number:</label>
      <input type="tel" id="phone" name="phone" value="<%=(user.getPhone() != 0) ? user.getPhone() : ""%>">

      <label for="email">Email ID:</label>
      <input type="email" id="email" name="mail" value="<%=(user.getMail() != null) ? user.getMail() : ""%>">

      <label for="branch">Branch:</label>
      <input type="text" id="branch" name="branch" value="<%=(user.getBranch() != null) ? user.getBranch() : ""%>">

      <label for="location">Location:</label>
      <input type="text" id="location" name="loc" value="<%=(user.getLoc() != null) ? user.getLoc() : ""%>">

      <div class="form-footer">
        <button type="submit">Update Account</button>
        
        
       <button type="submit" onclick="location.href='Dashboard.jsp'">Back to Dashboard</button> 
        
      <!-- <form action="Dashboard.jsp" method="get" style="display: inline;">
           <button type="submit" class="btn btn-secondary">Back to Dashboard</button>
        </form> -->
        
      </div>
    </form>
  </div>
  
  <%}
  else{
	  request.setAttribute("error", "Session Expired..!");
	  RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	  rd.forward(request, response);
  }
  %>
  
  
</body>
</html>
   