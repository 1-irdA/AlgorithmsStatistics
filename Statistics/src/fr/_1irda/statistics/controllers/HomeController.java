/*
 * Home.java                                      26 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Controller Home.fxml
 * @author Adrien GARROUSTE
 */
public class HomeController extends Application {
    
    /** Button to choose algorithms */
    @FXML
    private Button btnWindowStats;
    
    /** Button to open about page */
    @FXML
    private Button btnAbout;
    
    /** GitHub link */
    @FXML
    private Hyperlink gitHubLink;
    
    /** Personal site link */
    @FXML
    private Hyperlink personnalLink;
 
    /**
     * Statistics window
     * @param event button click
     */
    @FXML
    public void clickWindowStatistics(ActionEvent event) {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/Statistics.fxml"));
        
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Statistiques");
            stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("../assets/images/logo.png")));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * About window
     * @param event button click
     */
    public void clickWindowAbout(ActionEvent event) {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/About.fxml"));
        
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("À propos");
            stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("../assets/images/logo.png")));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * On click on github link
     * @param event on click
     */
    @FXML
    public void clickGitHubLink(ActionEvent event) {
        getHostServices().showDocument("https://github.com/1-irdA/");
    }
    
    /**
     * On click on personal website link
     * @param event on click
     */
    public void clickPersonalLink(ActionEvent event) {
        getHostServices().showDocument("https://1irda.alwaysdata.net");
    }

    /*
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage arg0) throws Exception {
        /* just to get host services */
    }
}
