/*
 * FilesUtils.java                                      3 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import fr._1irda.statistics.models.AllResults;
import fr._1irda.statistics.models.Result;
import fr._1irda.statistics.models.Stat;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Save operations
 * @author Adrien GARROUSTE
 */
public class FilesUtils {

    private static final String SERIALIZE_FILE = "save";

    /**
     * Save the chart
     * @param chartPane anchor pane of chart
     * @param chartToSave chart to save
     * @return true if saved
     */
    public static boolean saveChart(AnchorPane chartPane, 
            LineChart<String, Double> chartToSave) {

        /* save chart image without see chart on current window */
        Scene sceneToSave = new Scene(new Group());
        ((Group) sceneToSave.getRoot()).getChildren().add(chartToSave);
        WritableImage image = null;
        File file = null;
        FileChooser fileChooser = new FileChooser();;
        Stage fileChooserStage = (Stage) chartPane.getScene().getWindow();;
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*.png", "*.PNG");

        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showSaveDialog(fileChooserStage);

        /* save chart scene */
        image = sceneToSave.snapshot(null);

        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     * Save statistics results
     * @param anchorPane anchor pane of tab
     * @param results data to save
     * @return true if saved
     */
    public static boolean saveInCsv(AnchorPane anchorPane, Stat[] results) {

        File file = null;
        FileChooser fileChooser = new FileChooser();
        Stage fileChooserStage = (Stage) anchorPane.getScene().getWindow();
        PrintWriter writer = null;

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*.csv", "*.CSV");

        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showSaveDialog(fileChooserStage);

        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (file != null) {
            writer.println("Génération(s) : " + results.length + ";");
            writer.println("Taille; Temps de tri (secondes);");
            for (Stat stat : results) {
                writer.println(stat.getSize() + ";" + stat.getSortingTime() + ";");
            }
            writer.close();
        }

        return true;
    }

    /**
     * Serialize result
     * @param toSave
     */
    public static void serialize(AllResults toSave) {

        try (ObjectOutputStream writer = 
                new ObjectOutputStream(new FileOutputStream(SERIALIZE_FILE))) {
            
            for (Result result : toSave.getResults()) {
                writer.writeObject(result);
            }
            
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Get all saved result
     * @return no serialized saved result
     */
    public static ArrayList<Result> deserialize() {

        /** 
         * Array of results
         */
        ArrayList<Result> allResults = new ArrayList<>();

        /**
         * To continue to read
         */
        boolean still = true;

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(SERIALIZE_FILE))) {

            while (still) {
                try {
                    allResults.add((Result) reader.readObject());
                } catch (IOException e) {
                    still = false;
                } catch (ClassNotFoundException e) {
                    return allResults;
                } 
            }
            
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return allResults;
    }
    
    /**
     * Open file chooser and return file choose by user
     * @param anchorPane support widgets
     * @return a file choose by user
     */
    public static File takeFile(AnchorPane anchorPane) {
        
        File file = null;
        FileChooser fileChooser = new FileChooser();;
        Stage fileChooserStage = (Stage) anchorPane.getScene().getWindow();;
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*.png", "*.PNG");
        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showOpenDialog(fileChooserStage);
        
        return file;
    }
}