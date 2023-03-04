package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseUtils {
    static Connection con;
    static Statement statement;
    static ResultSet resultSet;

    public static void initializeDBProperties() {
        try {
            String url = ConfigReader.getProperty("db.url") ;
            // static String url="jdbc:mysql://localhost:3306/bootcamp"; //api, database, serverName, portNumber, nameOfDatabase
            String username=ConfigReader.getProperty("db.username");
            // static String username="root";
            String password=ConfigReader.getProperty("db.password");
            //  static String password="GulnurTestSQL1&";
            Class.forName("com.mysql.cj.jdbc.Driver"); //system.setProperty same as that --registering driver
            con = DriverManager.getConnection(url, username, password); //establishes connection to the database --getting the connection
            statement = con.createStatement(); //create a statement reference variable from statement interface
            // A connection (session) with a specific database. SQL statements are executed and results are returned within the context of a connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        ResultSet resultSet = null; // need to figure out y we need it
        try {
            resultSet = statement.executeQuery(query);
            // ResultSet rs= statement.executeQuery("SELECT * FROM bootcamp.employees limit 8;"); //ResultSet is an interface
            // The ResultSet interface provides getter methods (getBoolean, getLong, and so on) for retrieving column values from the current row.
            // Values can be retrieved using either the index number of the column or the name of the column.
            // In general, using the column index will be more efficient. Columns are numbered from 1.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void deleteQuery(String query){
        try {
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void closeDataBaseConnection(){
        try{
            statement.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException { //Practice
        ConfigReader.initializeProperties();

        DatabaseUtils.initializeDBProperties();
        //ResultSet rs = DatabaseUtils.executeQuery("SELECT CURDATE();"); // to check current date sql code
        ResultSet rs = DatabaseUtils.executeQuery("SELECT * FROM digitalbank.account where name = 'JavaLinks';");
        while(rs.next()){
            //System.out.println(rs.getDate(1));
            if(rs.getString(6).equals("javalinks")){
                System.out.println(rs.getString(2)+"  "+rs.getString(4)+"  "+rs.getString(6));
            }
        }
        DatabaseUtils.closeDataBaseConnection();
    }

}
