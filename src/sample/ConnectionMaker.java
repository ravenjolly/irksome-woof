package sample;

import javafx.scene.text.Text;

import java.sql.*;

/**
 * Created by raven on 8/31/2015.
 */
public class ConnectionMaker {
    //public static String connectionString = "jdbc:mysql://52.2.203.78/test";
    public static String connectionString = "jdbc:mysql://localhost/test";


    public static String user = "test";
    public static String pass = "hihacker";

    public static Connection connection;
    public static Statement command;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    //public static prepareStatement data;

    public static String currentUser;


    public static void connect() {

        try {

            //connection = DriverManager.getConnection(connectionString, user, pass);
            connection = DriverManager.getConnection(connectionString);



            Main.connectedBool = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createUser(){
        try {
            command = connection.createStatement();
            command.execute("INSERT INTO users (name, pin) VALUES ('" + (Main.username)+ "', '" + (Main.password) + "')");

            Main.loginChecker = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }}



    public static void login(){
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE pin =?");
            //preparedStatement.setString(2, Main.username);
            preparedStatement.setString(1, Main.password);

            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();


            //currentUser = String.valueOf(resultSet);
            while(resultSet.next()) {
                String columnValue = resultSet.getString(1);
                //System.out.println(columnValue);
                Main.currentUser = new Text(columnValue);
            }

            Main.loginChecker = 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }



/*



     public static void dplayresults(){
        {
            try {

                if (data.first()) {

                    while (data.next())
                        data.getString("name");



                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    */

}
