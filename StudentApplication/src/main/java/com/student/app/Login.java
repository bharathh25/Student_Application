package com.student.app; 
import java.util.ArrayList;
import java.util.Scanner; 
import com.student.dao.StudentDAO; 
import com.student.dao.StudentDAOImpl; 
import com.student.dto.Student; 
 
public class Login { 
public static void login() { 
Scanner sc=new Scanner(System.in); 
StudentDAO sdao=new StudentDAOImpl(); 
int choice=0; 
System.out.println("Enter the mail ID:"); 
String mail=sc.next(); 
System.out.println("Enter the password:"); 
String password=sc.next(); 
Student s=sdao.getStudent(mail, password); 
//sc.close();
if(s!=null) { 
System.out.println("login successful, Welcome "+s.getName()); 
do {
	System.out.println("1. View Account"); 
    System.out.println("2. Update Account"); 
    System.out.println("3. Search User"); 
    System.out.println("4. Main menu"); 
    if(s.getId()==1) {//for admin purpose 
     System.out.println("5. Delete User"); 
     System.out.println("6. View all Students"); 
      
    } 
    choice=sc.nextInt(); 
    switch(choice) { 
    case 1: System.out.println(s); 
    break; 
    case 2: Update.update(s); 
    break; 
    case 3: System.out.println("Enter the username:");
    		ArrayList<Student> studentList = sdao.getStudent(sc.next());
    		for(Student s1:studentList) {
    			System.out.println(s1);
    		}
    break; 
    case 4: System.out.println("Going back to main menu.."); 
    break; 
    case 5: System.out.println("Enter the Student ID to be deleted:");
    boolean res =sdao.deleteStudent(sc.nextInt());
    if(res) {
    	System.out.println("The Entered ID deleted successfully...");
    }
    else {
    	System.out.println("Failed to Login...");
    }
    break; 
    case 6: ArrayList<Student> studentList1= sdao.getStudent();
    for(Student s1:studentList1) {
    	System.out.println(s1);
    }
    break; 
    default:System.out.println("Invalid choice, choose the right one"); 
    break; 
    } 
   }while(choice!=4);
}
else { 
System.out.println("Failed to login"); 
}  
} 
}