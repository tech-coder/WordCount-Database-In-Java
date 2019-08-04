import java.sql.*;
public class ConnectionSql {
	static String myDriver = "com.mysql.cj.jdbc.Driver";
   static  String myUrl = "jdbc:mysql://localhost/assignment";
public static Connection getConnection(){
	Connection conn=null;
	try{
	Class.forName(myDriver);  
	conn=DriverManager.getConnection(myUrl,"root","pankajsingh");  
	if (conn == null) {
        System.out.println("Connection cannot be established");
    }
	}
	catch(Exception e){
		System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	}
return conn;
	
}
}
