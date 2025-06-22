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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession(true);
		
		StudentDAO sdao = new StudentDAOImpl();
		//PrintWriter out = resp.getWriter();
		
		Student s = sdao.getStudent(req.getParameter("mail"), req.getParameter("password"));
		if(s!=null) {
			//out.println("<h1>Login Successful...."+s.getName()+"</h1>");
			session.setAttribute("Student", s);
			req.setAttribute("success", "Logged in Successfully...");
			RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		
		else {
			//out.println("<h1>Login Failed....</h1>");
			req.setAttribute("error", "Login Failed...!!!");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
