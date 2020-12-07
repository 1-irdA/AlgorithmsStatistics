/*
 * Main.java                                      26 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Launching class 
 * @author Adrien GARROUSTE
 */
public class Main extends Application {
    
    /**
     * Build scene
     */
    @Override
    public void start(Stage primaryStage) {  
        try {
            Parent root = FXMLLoader.load(getClass().getResource("views/Home.fxml"));
            Scene scene = new Scene(root);
        
            primaryStage.setTitle("Statistiques");
            primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("assets/images/logo.png")));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** 
     * Start program
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
