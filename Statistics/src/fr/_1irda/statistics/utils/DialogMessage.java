/*
 * DialogMessage.java                                      26 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Optional;

import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * Class to manage message with dialogs message
 * @author Adrien GARROUSTE
 */
public class DialogMessage {

    /**
     * Display error message
     * @param title error title
     * @param header error header
     * @param message error content message
     */
    public static void errorMessage(String title, String header, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /** 
     * Display confirmation message
     * @param title confirmation title
     * @param header confirmation header
     * @param message confirmation message
     */
    public static void confirmMessage(String title, String header, String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Message to save chart or take chart image
     * @param anchorPane pane
     * @param toSave chart to save if user want
     * @return user file path
     * @throws MalformedURLException if incorrect
     */
    public static String fileMessage(AnchorPane anchorPane, 
            LineChart<String, Double> toSave) throws MalformedURLException {
        
        File userFile = null;
        String path = null;

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Choix d'une action");
        alert.setHeaderText("Choisir un graphique ou enregistrer "
                + "le graphique actuel ?");
        alert.setContentText("Pour enregistrer les générations "
                + "vous devez choisir "
                + "\nune image d'un graphique existante ou enregistrer "
                + "le graphique actuel.");

        ButtonType takeImg = new ButtonType("Choisir une image existante");
        ButtonType saveImg = new ButtonType("Enregistrer le graphique");
        ButtonType cancel = new ButtonType("Annuler", 
                ButtonData.CANCEL_CLOSE);
        
        alert.getButtonTypes().setAll(takeImg, saveImg, cancel);
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == takeImg){
            userFile = FilesUtils.takeFile(anchorPane);
        } else if (result.get() == saveImg) {
            userFile = FilesUtils.saveChart(anchorPane, toSave);
        } 
        
        if (userFile != null) {
              path = userFile.toURI().toURL().toString();  
        }
        
        return path; 
    }
}
