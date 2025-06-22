<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.student.dto.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
    	.success{
			color: green;    	
    	}
    </style>
</head>
<body>


<%
  Student s = (Student) session.getAttribute("Student");
  if (s == null) {
%>
	    <div class="alert alert-danger text-center mt-4">
	        Access Denied. Please <a href="Login.jsp">Login</a>.
	    </div>
	<%
    return;
  }
%>




    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
			<a class="navbar-brand" href="Dashboard.jsp">Welcome, <%= (s.getName() != null) ? s.getName() : "" %></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                  <% if(s.getId() == 1) { %>   
                    <li class="nav-item">
                        <a class="nav-link" href="#">View Users</a>
                    </li>
                    <%}%> 
                    <li class="nav-item">
                        <a class="nav-link" href="#">Reset Password</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="UpdateAccount.jsp">Update Account</a>
                    </li>
                    <li class="nav-item">
                        <form action="logout" method="post" class="d-inline">
                            <input class="btn btn-danger" type="submit" name="logout" value="Logout">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <!-- User Section -->
    <div class="container mt-4">
        <h1 class="text-center mb-4">Dashboard</h1>
        
    <%if(request.getAttribute("success")!=null){ %>
    <h3 align="center" class="success"><%=request.getAttribute("success")%></h3>
    <%}%>
        
        
        
        <div class="row">
            <div class="col-md-12">
                <h3>View Your Data</h3>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Mail ID</th>
                            <th>Branch</th>
                            <th>Location</th>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <!-- Data rows will go here -->
                        <td><%= (s.getId() != 0) ? s.getId() : "" %></td>
						<td><%= (s.getName() != null) ? s.getName() : "" %></td>
						<td><%= (s.getPhone() != 0) ? s.getPhone() : "" %></td>
						<td><%= (s.getMail() != null) ? s.getMail() : "" %></td>
						<td><%= (s.getBranch() != null) ? s.getBranch() : "" %></td>
						<td><%= (s.getLoc() != null) ? s.getLoc() : "" %></td>

                     </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
