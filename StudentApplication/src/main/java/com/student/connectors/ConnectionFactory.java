package com.student.connectors; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

//connector factory class 
public class ConnectionFactory { 
public static Connection requestConnection() { 
Connection con=null; 
String url="jdbc:mysql://localhost:3306/College"; 
String user="root"; 
String password="SQL@2025"; 
try { 
Class.forName("com.mysql.cj.jdbc.Driver"); 
con=DriverManager.getConnection(url, user, password);

} catch (ClassNotFoundException | SQLException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} 
return con; 
}
}
