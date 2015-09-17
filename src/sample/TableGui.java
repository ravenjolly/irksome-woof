package sample;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by raven on 9/5/2015.
 */
public class TableGui {
    static Text togo, serverName, tableNumber;
    static GridPane grid = new GridPane();


public static Scene tableGui(){






    Scene scene = new Scene(grid, 800, 600);
    Main.primaryStage.setScene(scene);
    return scene;
}



    public static VBox tableList(){
        VBox vbox = new VBox(20);


        return vbox;
    }


    public static void keypad(){
        TextField text = new TextField("input");
        Stage keypad = new Stage();
        VBox hbox1 = new VBox(5);
        VBox hbox2 = new VBox(5);
        VBox hbox3 = new VBox(5);

        BorderPane border = new BorderPane();
        border.setTop(text);
        border.setLeft(hbox1);
        border.setCenter(hbox2);
        border.setRight(hbox3);
        Button B1 = new Button("1");
        Button B2 = new Button("2");
        Button B3 = new Button("3");
        Button B4 = new Button("4");
        Button B5 = new Button("5");
        Button B6 = new Button("6");
        Button B7 = new Button("7");
        Button B8 = new Button("8");
        Button B9 = new Button("9");
        Button B0 = new Button("0");

        hbox1.getChildren().addAll()


        Scene scene= new Scene(hbox,300,400);
        keypad.setScene(scene);
        keypad.show();
    }




}





