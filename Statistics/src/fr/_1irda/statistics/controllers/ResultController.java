/*
 * ResultController.java                                      4 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;

import fr._1irda.statistics.models.Result;
import fr._1irda.statistics.models.Stat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controller of Result.fxml
 * @author Adrien GARROUSTE
 */
public class ResultController {
    
    /** Chart image of result */
    @FXML
    private ImageView chartImg;
    
    /** Text area to display general informations of this save */
    @FXML
    private TextArea textAreaInfos;
    
    /** Contains array */
    @FXML
    private ListView<String> listViewArray;
    
    /** Click saved result */
    private Result clickedResult;
    
    /** Statistics in saved result */
    private Stat[] stats;
    
    /**
     * Initialize window
     * @param clickedResult result where user click
     */
    @FXML
    public void initialize(Result clickedResult) {
        this.clickedResult = clickedResult;
        this.stats = this.clickedResult.getStats();
        Image img = null;
        double totalTime = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        

        img = new Image(this.clickedResult.getImgPath());
        
        if (img.getWidth() != 0) {
            chartImg.setImage(img);
        }
      
        for (Stat stat : this.stats) {
            listViewArray.getItems().add("Taille : " + stat.getSize()
            + " - Temps de tri : " + stat.getSortingTime());
            totalTime += stat.getSortingTime();
        }
        
        textAreaInfos.setText("Nombre de générations : " + this.stats.length 
                + "\nTemps total de tri : " + totalTime + " secondes"
                + "\nDate enregistrement : " 
                + dateFormat.format(this.clickedResult.getCreatedAt()));
    }
    
    /**
     * Open details
     * @param event
     */
    @FXML
    public void openDetails(MouseEvent event) {

        int clickedIndex = listViewArray.getSelectionModel().getSelectedIndex();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/Details.fxml"));

        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            DetailsController controller = fxmlLoader.getController();

            controller.initialize(this.stats[clickedIndex]);
            stage.setScene(new Scene(root));
            stage.setTitle("Détails");
            stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("../assets/home.png")));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
