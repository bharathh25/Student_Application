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


@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = new Student();
		StudentDAO sdao = new StudentDAOImpl();
		//PrintWriter out =resp.getWriter();
		resp.setContentType("text/html");
		
		
		s.setName(req.getParameter("name"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			boolean res = sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Data added successfully...</h1>");
				req.setAttribute("success", "Data saved Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
				//rd.include(req,resp); imp mtd..
			}
			else {
				//out.println("<h1>Sign up error...</h1>");
				req.setAttribute("error", "Failed to Create the Account...!!!");
				RequestDispatcher rd = req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			//out.println("<h2>Password mismatch...</h2>");
			req.setAttribute("error", "Password Mismatch...!!!");
			RequestDispatcher rd = req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		}
		
	}	
}
