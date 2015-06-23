package ch4.database;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/23
 * Email: billchen01@163.com
 */

public class TestDB {
    public static void main(String[] args){
        try {
            runTest();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
        }
    }

    public static void runTest() throws IOException, SQLException {

        Connection conn = getConnection();
        try{
            Statement stat = conn.createStatement();
            stat.execute("CREATE TABLE Greetings (Message CHAR(20))");
            stat.execute("INSERT INTO Greetings VALUES ('Hello, World!')");

            ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
            result.next();
            System.out.println(result.getString(1));
            stat.execute("DROP TABLE Greetings");
        }finally {
            conn.close();
        }

    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        BufferedInputStream in = (BufferedInputStream) TestDB.class.getResourceAsStream("database.properties");
        props.load(in);
        in.close();
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }
}
