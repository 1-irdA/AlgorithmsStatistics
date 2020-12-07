/*
 * DetailsController.java                                      3 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.controllers;

import fr._1irda.statistics.models.Stat;
import fr._1irda.statistics.utils.Informations;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * Controller of Details.fxml
 * @author Adrien GARROUSTE
 */
public class DetailsController {

    /** List of all values */
    @FXML
    private ListView<Double> listViewElements;

    /** Array size label */
    @FXML
    private Label labelSize;

    /** Generation label */
    @FXML
    private Label labelGeneration;

    /** Sorting time label */
    @FXML
    private Label labelSortingTime;

    /** Sorting algorithm */
    @FXML
    private Label labelSortingAlgo;

    /** Informations on algorithm */
    @FXML
    private Label labelInformations;

    /**
     * Get data from other page
     * @param clickedStat statistique where user click
     */
    @FXML
    public void initialize(Stat clickedStat) {

        double[] values = clickedStat.getValues();

        /* begin at the end to keep the same order than the generation */
        for (int i = 0; i < values.length; i++) {
            listViewElements.getItems().add(values[i]);
        }

        labelSize.setText(labelSize.getText() + clickedStat.getSize());
        labelGeneration.setText(labelGeneration.getText() 
                + " " + clickedStat.getBeforeUpdateGeneration());
        labelSortingAlgo.setText(labelSortingAlgo.getText() 
                + clickedStat.getBeforeUpdateSortAlgo());
        labelSortingTime.setText(labelSortingTime.getText() 
                + clickedStat.getSortingTime() + " secondes");

        /* Find algorithm in algorithms informations array and write them */
        for (String[] info : Informations.ALGO_DETAILS) {
            if (info[0].equals(clickedStat.getBeforeUpdateSortAlgo())) {
                labelInformations.setText(info[1] + "\n"
                        + info[2] + "\n"
                        + info[3]);
            }
        }
    }
}
