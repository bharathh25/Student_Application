package com.studentapp.servlets;

import java.io.IOException;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student s=new Student();
		StudentDAO sdao= new StudentDAOImpl();
		int id = (Integer.parseInt(req.getParameter("id")));
		if(sdao.deleteStudent(id)) {
			req.setAttribute("success","Data deleted successfully");
			RequestDispatcher rd = req.getRequestDispatcher("ViewUsers.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("error","Failed to delete the data..!!");
			RequestDispatcher rd = req.getRequestDispatcher("ViewUsers.jsp");
			rd.forward(req, resp);
		}
		
	}
}
