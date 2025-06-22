package com.student.app;

import java.util.Scanner;
import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.dto.Student;

public class ForgotPassword {
    public static void password() {
        Scanner sc = new Scanner(System.in);
        StudentDAO sdao = new StudentDAOImpl();

        System.out.println("<----FORGOT PASSWORD---->");

        System.out.print("Enter your registered Phone number: ");
        long phone = sc.nextLong();

        System.out.print("Enter your registered Mail ID: ");
        String mail = sc.next();

        // Fetch student based on phone and mail
        Student s = sdao.getStudent(phone, mail);

        if (s != null) {
            System.out.println("Account found for: " + s.getName());
            System.out.print("Enter new password: ");
            String newPassword = sc.next();

            System.out.print("Confirm new password: ");
            String confirmPassword = sc.next();

            if (newPassword.equals(confirmPassword)) {
                s.setPassword(newPassword); // set the new password
                boolean updated = sdao.updateStudent(s); // reuse updateStudent() method
                if (updated) {
                    System.out.println("Password reset successfully!");
                    WelcomeApp.main(null);
                } else {
                    System.out.println("Failed to update password. Please try again.");
                }
            } else {
                System.out.println("Password mismatch! Please try again.");
            }
        } else {
            System.out.println("No user found with the given Phone number and Mail ID.");
        }
    }
}
