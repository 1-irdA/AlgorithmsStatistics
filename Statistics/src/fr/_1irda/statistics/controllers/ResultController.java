/*
 * ResultController.java                                      4 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.controllers;

import fr._1irda.statistics.models.Result;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controller of Result.fxml
 * @author Adrien GARROUSTE
 */
public class ResultController {
    
    /** Chart image of result */
    @FXML
    private ImageView chartImg;
    
    /**
     * Initialize window
     * @param clickedResult result where user click
     */
    @FXML
    public void initialize(Result clickedResult) {
        Image img = new Image(clickedResult.getImgPath());
        chartImg.setImage(img);
    }

}
