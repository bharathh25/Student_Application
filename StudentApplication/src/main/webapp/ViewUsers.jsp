<%@page import="com.student.dao.StudentDAOImpl"%>
<%@page import="com.student.dao.StudentDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
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


<%Student admin=(Student)session.getAttribute("Student");
if(admin!=null && admin.getId()==1){%>


     

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
			<a class="navbar-brand" href="Dashboard.jsp">Welcome Admin, <%= (admin.getName() != null) ? admin.getName() : "" %> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                
                    <li class="nav-item me-2">
                      <form action="Dashboard.jsp" method="get" class="d-inline">
                          <input class="btn btn-primary" type="submit" value="Back to Dashboard">
                      </form>
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
        <h1 class="text-center mb-4">All Users</h1>
        
    	<div align="center">
			<% if(request.getAttribute("success")!=null){%>
			<h3 class="text-success"><%=request.getAttribute("success") %></h3>    	
    		<%} %>
    		<% if(request.getAttribute("error")!=null){%>
			<h3 class="text-danger"><%=request.getAttribute("error") %></h3>    	
    		<%} %>
    	</div>

        
        
        
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
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <%StudentDAO sdao = new StudentDAOImpl(); 
                       ArrayList<Student> students=sdao.getStudent();%>
                      
                    <tbody>
                     <%for(Student s:students){ %>
                    <tr>
                        <!-- Data rows will go here -->
                        <td><%= (s.getId() != 0) ? s.getId() : "" %></td>
						<td><%= (s.getName() != null) ? s.getName() : "" %></td>
						<td><%= (s.getPhone() != 0) ? s.getPhone() : "" %></td>
						<td><%= (s.getMail() != null) ? s.getMail() : "" %></td>
						<td><%= (s.getBranch() != null) ? s.getBranch() : "" %></td>
						<td><%= (s.getLoc() != null) ? s.getLoc() : "" %></td>
						<td>
						<form action="deleteUser" method="post">
							<input type="hidden" name="id" value="<%= (s.getId() != 0) ? s.getId() : "" %>">
							<input type="submit" class="btn btn-danger" value="Delete">
						</form>							
						</td>
                     </tr>
                     <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <%}
  else{
	  request.setAttribute("error", "Session Expired..!");
	  RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	  rd.forward(request, response);
  }
  %>
</body>
</html>
   