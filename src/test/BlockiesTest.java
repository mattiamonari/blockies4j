package test;

import blockies.Blockies;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BlockiesTest extends Application {
    BorderPane p;
    Scene scene;
    Blockies blockie;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {

        //Instantiate all the variables.
        initComponents();

        //Scene creation
        p.setCenter(blockie);
        scene = new Scene(p , 400 , 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private void initComponents() {
        p = new BorderPane();
        blockie = new Blockies("0x00000000219ab540356cBB839Cbe05303d7705Fa", 8, 16); //Custom creation.
        blockie = new Blockies("0x00000000219ab540356cBB839Cbe05303d7705Fa");  //Default creation using size = 8 and scale = 15.
        blockie = new Blockies(); //Default creation using random string, size = 8 and scale = 15.
        BorderPane.setMargin(blockie, new Insets(0,0,150,0));
    }
}