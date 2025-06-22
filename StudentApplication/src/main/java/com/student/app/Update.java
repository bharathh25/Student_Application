package com.student.app; 
 
import java.util.Scanner; 
 
import com.student.dao.StudentDAO; 
import com.student.dao.StudentDAOImpl; 
import com.student.dto.Student; 
 
public class Update { 
 public static void update(Student s) { 
  Scanner sc=new Scanner(System.in); 
  StudentDAO sdao=new StudentDAOImpl(); 
  int in=0;
  //sc.close();
  boolean status=false; 
  do { 
   System.out.println("Enter the field, you would like to update:"); 
   System.out.println("1. NAME"); 
   System.out.println("2. PHONE"); 
   System.out.println("3. MAIL"); 
   System.out.println("4. BRANCH"); 
   System.out.println("5. LOCATION"); 
   System.out.println("6. BACK"); 
   in=sc.nextInt(); 
   switch(in) { 
   case 1: System.out.println("Enter the name to be updated:"); 
   s.setName(sc.next()); 
   break; 
   case 2: System.out.println("Enter the new Phone number"); 
   s.setPhone(sc.nextLong()); 
   break; 
   case 3: System.out.println("Enter the mail"); 
   s.setMail(sc.next()); 
   break; 
   case 4: System.out.println("Enter the Branch"); 
   s.setBranch(sc.next()); 
   break; 
   case 5: System.out.println("Enter the location:"); 
   s.setLoc(sc.next()); 
   break; 
   case 6: System.out.println("loading..."); 
   break; 
   default:System.out.println("Enter the valid option:"); 
   break; 
   } 
   status=sdao.updateStudent(s); 
   if(status) { 
    System.out.println("Data updated successfully"); 
   }else { 
    System.out.println("Failed to update the data"); 
   }  
  } 
  while(in!=6); 
 } 
}