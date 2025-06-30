package com.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao= new StudentDAOImpl();
		//PrintWriter out = resp.getWriter();
		Student s= sdao.getStudent(Long.parseLong(req.getParameter("phone")), req.getParameter("mail"));
		
		if (s != null) {
		    if (req.getParameter("newpassword").equals(req.getParameter("confirmpassword"))) {
		        if (req.getParameter("newpassword").equals(s.getPassword())) {
		            //out.println("<h1>You can't set the old password as new Password...!!!</h1>");
		        	req.setAttribute("error", "You can't set the old password as new Password...!!!");
		        	RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword.jsp");
		        	rd.forward(req, resp);
		        	
		        } else {
		            s.setPassword(req.getParameter("newpassword"));
		            if (sdao.updateStudent(s)) {
		                //out.println("<h1>Password Updated Successfully... " + s.getName() + "</h1>");
		                //out.println("<a href='Login.html'>Back to Login</a>");
		            	req.setAttribute("success", "Password Updated Successfully...");
			        	RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			        	rd.forward(req, resp);
		            } else {
		                //out.println("<h1>Failed to Update the Password....!!!!</h1>");
		            	req.setAttribute("error", "Failed to update the password...!!!");
			        	RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword.jsp");
			        	rd.forward(req, resp);
		            }
		        }
		    } else {
		        //out.println("<h1>Password Mismatch..!!!</h1>");
		    	req.setAttribute("error", "Password mismatch...!!!");
	        	RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword.jsp");
	        	rd.forward(req, resp);
		    }
		} else {
		    //out.println("<h1>User Credentials not found...!!!!</h1>");
			req.setAttribute("error", "User credentials not found...!!!");
        	RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword.jsp");
        	rd.forward(req, resp);
		}

	}
	
}
