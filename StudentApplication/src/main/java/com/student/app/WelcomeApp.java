package com.student.app; 
 
import java.util.Scanner; 
 
public class WelcomeApp { 
 public static void main(String[] args) { 
  int in=0; 
  Scanner sc=new Scanner(System.in); 
  System.out.println("Welcome to Student App");
  //sc.close();
  do { 
   System.out.println("1. LOGIN"); 
   System.out.println("2. SIGNUP"); 
   System.out.println("3. FORGOT PASSWORD");
   System.out.println("4. EXIT"); 
   in=sc.nextInt(); 
   switch(in) { 
   case 1: Login.login(); 
    break; 
   case 2: Signup.signup(); 
    break; 
   case 3: ForgotPassword.password();
   case 4: System.out.println("Application closed...."); 
   break; 
   default:System.out.println("Invalid choice!Try again"); 
   break; 
   }
  }while(in!=4); 
 } 
 } 

