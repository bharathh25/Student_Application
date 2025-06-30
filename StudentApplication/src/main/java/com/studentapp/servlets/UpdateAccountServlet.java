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
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateAccount")
public class UpdateAccountServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("Student") == null) {
			req.setAttribute("error", "Session expired. Please login again.");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
			return;
		}

		StudentDAO sdao = new StudentDAOImpl();
		Student s = (Student) session.getAttribute("Student");

		// Get form values
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String mail = req.getParameter("mail");
		String branch = req.getParameter("branch");
		String loc = req.getParameter("loc");

		// Check if user made any changes
		boolean noChange = name.equals(s.getName()) &&
		                   phone == s.getPhone() &&
		                   mail.equals(s.getMail()) &&
		                   branch.equals(s.getBranch()) &&
		                   loc.equals(s.getLoc());

		if (noChange) {
			req.setAttribute("info", "No changes made.");
			RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
			return;
		}

		// Update only if changes are made
		s.setName(name);
		s.setPhone(phone);
		s.setMail(mail);
		s.setBranch(branch);
		s.setLoc(loc);

		if (sdao.updateStudent(s)) {
			session.setAttribute("Student", s);
			req.setAttribute("success", "Account Updated successfully.");
			RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("error", "Failed to Update the Account..!!!!");
			RequestDispatcher rd = req.getRequestDispatcher("UpdateAccount.jsp");
			rd.forward(req, resp);
		}
	}
}
