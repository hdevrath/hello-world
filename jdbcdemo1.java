import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;import java.io.*;
import java.util.Scanner;import java.sql.*;
class JdbcDemo1{ public  static void main(String []args) throws Exception 
{//step 1 for loading driver  
System.out.println("Enter the id and name");
Scanner s=new Scanner(System.in);
int id=s.nextInt();    
String name=s.next();  
Class.forName("oracle.jdbc.driver.OracleDriver"); 
//step 2 for providing connection  
Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","harry","lion");
//step 3 using statement  Statement st=con.createStatement();
//step 4 for processing query usning statement method // 
st.executeUpdate("create table emp(id int, name varchar2(20))"); 
// st.executeUpdate("insert into emp values (3284,'harshn')"); 
PreparedStatement ps=con.prepareStatement("insert into emp values(?,?)"); 
ps.setInt(1,id);  ps.setString(2,name);  ps.executeUpdate(); 
System.out.println("Row updated"); 
//step5 using result set for query 
String sql = "select * FROM emp"; 
ResultSet rs=st.executeQuery(sql);  
while(rs.next())
{   
System.out.println(rs.getInt(1)+ "\t" + rs.getString(2));  
}     //for getting metadata  
ResultSetMetaData rsmd=rs.getMetaData();
System.out.println("No. of columns:"+rsmd.getColumnCount());
//Step 6 clossing all objects  st.close();  con.close();
} 
}
