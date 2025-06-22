package com.student.dao; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;

import java.util.ArrayList; 


import com.student.connectors.ConnectionFactory;
import com.student.dto.Student; 
 
public class StudentDAOImpl implements StudentDAO{ 
private Connection con; 
 
 public StudentDAOImpl() { 
  this.con=ConnectionFactory.requestConnection(); 
 } 
//======================================================================================================//
 @Override 
 public boolean insertStudent(Student s) { 
  PreparedStatement ps=null; 
  String query="INSERT INTO STUDENT VALUES (0,?,?,?,?,?,?,sysdate())"; 
  int res=0; 
  try { 
   ps=con.prepareStatement(query); 
   ps.setString(1,s.getName()); 
   ps.setLong(2, s.getPhone()); 
   ps.setString(3, s.getMail()); 
   ps.setString(4, s.getBranch()); 
   ps.setString(5,s.getLoc()); 
   ps.setString(6, s.getPassword()); 
   res=ps.executeUpdate(); 
   
  } catch (SQLException e) { 
   // TODO Auto-generated catch block 
	  e.printStackTrace(); 
  } 
  if(res>0) { 
   return true; 
  } 
  else { 
   return false; 
  } 
 } 
//======================================================================================================//
 @Override 
 public boolean updateStudent(Student s) { 
  PreparedStatement ps=null; 
  String query="UPDATE STUDENT SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOC=?,PASSWORD=?,DATE=SYSDATE() WHERE ID=?"; 
  int res=0; 
  try { 
   ps=con.prepareStatement(query); 
   ps.setString(1, s.getName()); 
   ps.setLong(2,s.getPhone()); 
   ps.setString(3, s.getMail()); 
   ps.setString(4, s.getBranch()); 
   ps.setString(5, s.getLoc()); 
   ps.setString(6, s.getPassword()); 
   ps.setInt(7, s.getId()); 
   res=ps.executeUpdate(); 
  } catch (SQLException e) { 
   // TODO Auto-generated catch block 
	  e.printStackTrace(); 
  } 
  if(res>0) { 
   return true; 
  } 
  else { 
   return false; 
  } 
 } 
//======================================================================================================//
 @Override 
 public boolean deleteStudent(int id) { 
  // TODO Auto-generated method stub 
	 PreparedStatement ps = null;
	 int res=0;
	 String query ="DELETE FROM STUDENT WHERE ID=?";
	 try {
		ps=con.prepareStatement(query);
		ps.setInt(1,id);
		res=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 if(res>0) {
		 return true;
	 }
	 else {
		 return false;
	 }
   
 } 
//======================================================================================================//
 @Override 
 public Student getStudent(String mail, String password) { 
  PreparedStatement ps=null; 
  String query="SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?"; 
  Student s=null; 
  try { 
   ps=con.prepareStatement(query); 
   ps.setString(1,mail); 
   ps.setString(2, password); 
   ResultSet rs=ps.executeQuery(); 
   while(rs.next()) { 
    s=new Student();
    //int id=rs.getInt("id"); 
    //s.setId(id); 
    s.setId(rs.getInt("id")); 
    s.setName(rs.getString("name")); 
    s.setPhone(rs.getLong("phone")); 
    s.setMail(rs.getString("mail")); 
    s.setBranch(rs.getString("branch")); 
    s.setLoc(rs.getString("loc")); 
    s.setPassword(rs.getString("password")); 
    s.setDate(rs.getString("date")); 
   } 
    
  } catch (SQLException e) { 
   // TODO Auto-generated catch block 
   e.printStackTrace(); 
  } 
  return s; 
 } 
//======================================================================================================//
 @Override 
 public ArrayList<Student> getStudent() { 
  // TODO Auto-generated method stub 
	 PreparedStatement ps = null;
	 String query = "SELECT * FROM STUDENT";
	 ArrayList<Student> list = new ArrayList<>();
	 Student s = null;
	 
	 try {
		ps=con.prepareStatement(query);
		ResultSet rs = ps.executeQuery(query);
		while(rs.next()) {
			s=new Student();
			s.setId(rs.getInt("id")); 
		    s.setName(rs.getString("name")); 
		    s.setPhone(rs.getLong("phone")); 
		    s.setMail(rs.getString("mail")); 
		    s.setBranch(rs.getString("branch")); 
		    s.setLoc(rs.getString("loc")); 
		    s.setPassword(rs.getString("password")); 
		    s.setDate(rs.getString("date"));
		    list.add(s);
		    
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  return list; 
 }
//======================================================================================================//
@Override
public ArrayList<Student> getStudent(String name) {
	// TODO Auto-generated method stub
	PreparedStatement ps = null;
	 String query = "SELECT * FROM STUDENT WHERE NAME=?";
	 ArrayList<Student> list = new ArrayList<>();
	 Student s = null;
	 
	 try {
		ps=con.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new Student();
			s.setId(rs.getInt("id")); 
		    s.setName(rs.getString("name")); 
		    s.setPhone(rs.getLong("phone")); 
		    s.setMail(rs.getString("mail")); 
		    s.setBranch(rs.getString("branch")); 
		    s.setLoc(rs.getString("loc")); 
		    //s.setPassword("*****"); //s.setPassword(rs.getString("password"));    coz when searhing other users , u shld not see password
		    s.setDate(rs.getString("date"));
		    list.add(s);
		    
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 return list; 
	
}
//======================================================================================================//
@Override
public Student getStudent(long phone, String mail) {
	// TODO Auto-generated method stub
	PreparedStatement ps=null;
	 String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?";
	 Student s=null;
	 try {
	 ps=con.prepareStatement(query);
	 ps.setLong(1,phone);
	 ps.setString(2, mail);
	 ResultSet rs=ps.executeQuery();
	 while(rs.next()) {
	 s=new Student();
	 //int id=rs.getInt("id");
	 //s.setId(id);
	 s.setId(rs.getInt("id"));
	 s.setName(rs.getString("name"));
	 s.setPhone(rs.getLong("phone"));
	 s.setMail(rs.getString("mail"));
	 s.setBranch(rs.getString("branch"));
	 s.setLoc(rs.getString("loc"));
	 s.setPassword(rs.getString("password"));
	 s.setDate(rs.getString("date"));
	 }

	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 return s;
} 
}