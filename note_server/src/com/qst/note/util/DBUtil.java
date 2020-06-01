package com.qst.note.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.ws.Closeable;

public class DBUtil {

    static String dbName="note_db";
    static String name="root";   //数据库名
    static String pass="wangchao";  //数据库密码
    
    //测试是否连接成功
//    public static void main(String[] args) {
//		Connection c=getConnection();
//		try {
//			Statement st=(Statement)c.createStatement();
//			st.execute("insert into user(name,pass) values('zhangsan','23')");
//			
//			close(c, st, null);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
    
    
    
    
    public static Connection getConnection(){
    	Connection c=null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			 try {
				c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"?ssl=true",name,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
   
   public static void close(Connection c,Statement stat,ResultSet rs){
	   if(rs!=null){
		   try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   if(stat!=null){
		   try {
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   if(c!=null){
		   try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
   }
}
