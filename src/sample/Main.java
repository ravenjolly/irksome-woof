package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.sql.*;
import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application{
    public static Text connected = new Text("Connected");
    public static Text created = new Text("User Created");
    public static Text loggedIn = new Text("Logged in!");
    public static Text success = new Text("Successss");
    public static Text failed = new Text("failed");



    public static String list;
    public static String potato = list;
    public static String username;
    public static String password;

    public static int connectedBool = 0;
    public static int loginChecker = 0;
    public void start(Stage primaryStage) {


        BorderPane borderpane = new BorderPane();
        VBox hbox2 = new VBox(20);
        VBox hbox = new VBox(20);

        Button loginButton = new Button("Login");

        Button create = new Button("Create user");

        TextField name = new TextField("Name");
        TextField pin = new TextField("pin");



        ConnectionMaker.connect();
        if(connectedBool==1){
            hbox.getChildren().add(connected);
        }
        //ConnectionMaker.dplayresults();

        Text text = new Text("Hi");

        create.setOnAction(e ->{
            username = name.getText();
            password = pin.getText();
            ConnectionMaker.createUser();
            if(loginChecker==0){
                hbox.getChildren().add(failed);
            }else{
                hbox.getChildren().add(success);
            }
        });

        loginButton.setOnAction(e ->{


            username = name.getText();
            password = pin.getText();
            ConnectionMaker.login();

            if(loginChecker==0){
                hbox.getChildren().add(failed);
            }else{
                hbox.getChildren().add(success);
            }

        });




        hbox.getChildren().add(text);
        hbox2.getChildren().addAll(name,pin, loginButton, create);
        borderpane.setRight(hbox);
        borderpane.setLeft(hbox2);
        Scene scene = new Scene(borderpane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}


