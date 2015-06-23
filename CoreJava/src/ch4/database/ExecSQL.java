package ch4.database;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/23
 * Email: billchen01@163.com
 */

public class ExecSQL {

    public static void main(String[] args){
        try{
            Scanner in;
            if(args.length==0){
                in = new Scanner(System.in);
            }else {
                in = new Scanner(new File(args[0]));
            }

            try {
                Connection conn = getConnection();
                Statement stat = conn.createStatement();

                while (true){
                    if(args.length==0){
                        System.out.println("Enter command or EXIT to exit:");
                    }

                    if(!in.hasNextLine()){
                        return;
                    }

                    String line = in.nextLine();
                    if(line.equalsIgnoreCase("EXIT")){
                        return;
                    }
                    boolean hasResultSet = stat.execute(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        BufferedInputStream in = (BufferedInputStream) ExecSQL.class.getResourceAsStream("database.properties");
        props.load(in);
        in.close();

        String drivers = props.getProperty("jdbc.drivers");
        if(drivers != null){
            System.setProperty("jdbc.drivers", drivers);
        }

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }

}
