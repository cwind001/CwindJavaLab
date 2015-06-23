package ch4.database;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/22
 * Email: billchen01@163.com
 */
public class JDBCExample {
    public static void main(String[] args){
        System.out.println("-------- MySQL JDBC Connection Testing --------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/corejava", "javaer", "password");
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(connection != null){
            System.out.println("Conneceted to database 'corejava'.");
        }else {
            System.out.println("Failed to connect to database 'corejava'.");
        }

    }

}
