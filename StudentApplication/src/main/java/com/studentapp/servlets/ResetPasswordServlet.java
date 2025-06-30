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

@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDAO sdao = new StudentDAOImpl();

        long phone = Long.parseLong(req.getParameter("phone"));
        String mail = req.getParameter("mail");
        String newPassword = req.getParameter("newpassword");
        String confirmPassword = req.getParameter("confirmpassword");

        Student s = sdao.getStudent(phone, mail);

        if (s != null) {
            if (newPassword.equals(confirmPassword)) {
                if (newPassword.equals(s.getPassword())) {
                    req.setAttribute("error", "You can't use the old password as the new password.");
                    req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
                } else {
                    s.setPassword(newPassword);
                    if (sdao.updateStudent(s)) {
                        // 🔐 Invalidate session to log the user out
                        HttpSession session = req.getSession(false);
                        if (session != null) {
                            session.invalidate();
                        }
                        req.setAttribute("success", "Password updated successfully. Please login again.");
                        req.getRequestDispatcher("Login.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("error", "Failed to update the password. Please try again.");
                        req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
                    }
                }
            } else {
                req.setAttribute("error", "Password and Confirm Password do not match.");
                req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "User credentials not found.");
            req.getRequestDispatcher("ResetPassword.jsp").forward(req, resp);
        }
    }
}
