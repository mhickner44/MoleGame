/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mhick
 */
public class MoleGame extends Application {
    private boolean no=false;
    @Override
    public void start(Stage primaryStage) {   
        MolePane gamePane = new MolePane();
        Scene scene = new Scene(gamePane, -480, -50);
        primaryStage.setTitle("Whack A Mole");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setResizable(no);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
