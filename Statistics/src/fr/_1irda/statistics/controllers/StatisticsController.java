/*
 * StatsInsertionSort.java                                      26 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import fr._1irda.statistics.models.AllResults;
import fr._1irda.statistics.models.Result;
import fr._1irda.statistics.models.Stat;
import fr._1irda.statistics.models.Statistics;
import fr._1irda.statistics.utils.Chart;
import fr._1irda.statistics.utils.CheckFields;
import fr._1irda.statistics.utils.DialogMessage;
import fr._1irda.statistics.utils.FilesUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller StatsInsertionSort.fxml
 * @author Adrien GARROUSTE
 */
public class StatisticsController {

    /** TextField to choose number of test*/
    @FXML
    private TextField textFieldArraySize;

    /** TextField to choose array size */
    @FXML
    private TextField textFieldNbTests;

    /** Button to generate test */
    @FXML
    private Button btnGenerate;

    /** Available algorithms */
    @FXML
    private ComboBox<String> comboBoxAlgo;

    /** Available generations */
    @FXML
    private ComboBox<String> comboBoxGeneration; 

    /** Chart for random generation */
    @FXML
    private LineChart<String, Double> chart;

    /** X axis */
    @FXML
    private CategoryAxis xAxis;

    /** Y axis */
    @FXML
    private NumberAxis yAxis;

    /** List of all results */
    @FXML
    private ListView<String> listViewDetails;

    /** Display global results */
    @FXML
    private TextArea textAreaResults;

    /** Button to save chart image */
    @FXML
    private Button btnSaveChart;

    /** Button to save in CSV */
    @FXML
    private Button btnSaveCsv;

    /** Anchor pane who contains chart */
    @FXML
    private AnchorPane generalAnchorPane;

    /** Anchor pane who contains export tab */
    @FXML
    private AnchorPane anchorPaneExport;

    /** Text field to set name of result to serialize */
    @FXML
    private TextField textFieldSaveName;

    /** Button to save result */
    @FXML
    private Button btnSaveResults;

    /** List view with all saved results */
    @FXML
    private ListView<String> listViewMyData;

    /** Text field to input name to delete element */
    @FXML
    private TextField textFieldNameToDelete;

    /** Button to delete a saved result */
    @FXML
    private Button btnDelete;

    /** All statistics */
    private Stat[] allStats;

    /** All saved data */
    private AllResults allResults = new AllResults(FilesUtils.deserialize());

    /**
     * Initialize
     */
    @FXML
    public void initialize() {

        /* Get results in save file */
        ArrayList<Result> res = this.allResults.getResults();

        /* Add saved result in list view */
        for (int i = 0; i < res.size(); i++) {
            listViewMyData.getItems().add(i + " : " + res.get(i).getSaveName());
        }

        /* Add sorting algorithms */
        comboBoxAlgo.getItems().addAll("Tri par insertion",
                "Tri à bulles",
                "Tri à bulles optimisé",
                "Tri au peigne");

        comboBoxAlgo.getSelectionModel().select(0);

        /* Add generation algorithm */
        comboBoxGeneration.getItems().addAll("Aléatoire", "Descendante");
        comboBoxGeneration.getSelectionModel().select(0);

        /* If saved result, activate button */
        if (allResults.getResults().size() > 0) {
            btnDelete.setDisable(false);
        }

        /* If saved result active list view */
        if (listViewMyData.getItems().size() > 0) {
            listViewMyData.setDisable(false);
        }
    }

    /**
     * On click to generation button
     * @param event click on button
     */
    @FXML
    public void clickGenerate(ActionEvent event) {

        int nbTests, arraySize;
        String sortAlgo, generation;

        if (CheckFields.isValid(textFieldArraySize, textFieldNbTests)) {

            nbTests = Integer.parseInt(textFieldNbTests.getText().trim());
            arraySize = Integer.parseInt(textFieldArraySize.getText().trim());
            sortAlgo = comboBoxAlgo.getSelectionModel().getSelectedItem();
            generation = comboBoxGeneration.getSelectionModel().getSelectedItem();

            Statistics statistics = new Statistics(sortAlgo, generation, arraySize, nbTests);
            Chart chartObj = new Chart(chart, xAxis, yAxis, statistics.getStats());

            statistics.launch();
            chartObj.makeChart();

            DialogMessage.confirmMessage("Statistiques terminées !", 
                    "Statistiques effectuées avec succés !", 
                    "La génération des tableaux est terminée.\n"
                            + "Le graphique, les résultats et les détails"
                            + " sont disponibles.");

            /* display general informations */
            textAreaResults.setText("Nombre de générations : "
                    + nbTests + "\n" 
                    + "Temps total de tri : "
                    + statistics.getTotalSortingTime()
                    + " secondes\n"
                    + "Temps moyen de tri : "
                    + statistics.getTotalSortingTime() / nbTests
                    + " secondes");

            listViewDetails.getItems().clear();
            this.allStats = statistics.getStats();

            /* active button to save results */
            btnSaveChart.setDisable(false);
            btnSaveCsv.setDisable(false);
            btnSaveResults.setDisable(false);

            for (Stat stat : this.allStats) {
                listViewDetails.getItems().add(
                        "Taille : " + stat.getSize()
                        + " - Temps de tri : " 
                        + stat.getSortingTime()
                        + " secondes");
            }
        } else {
            DialogMessage.errorMessage("Erreur !", 
                    "Erreur de saisie.",
                    "Une erreur de saisie a été détectée.\n"
                            + "La taille du tableau doit être une valeur entière.\n"
                            + "Le nombre de test doit être une valeur entière"
                            + " supérieure à 1");
        }
    }

    /**
     * Open details
     * @param event
     */
    @FXML
    public void openDetails(MouseEvent event) {

        int clickedIndex = listViewDetails.getSelectionModel().getSelectedIndex();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/Details.fxml"));

        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            DetailsController controller = fxmlLoader.getController();

            controller.initialize(this.allStats[clickedIndex]);
            stage.setScene(new Scene(root));
            stage.setTitle("Détails");
            stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("../assets/home.png")));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save chart
     * @param event button click
     */
    @FXML
    private void saveChart(ActionEvent event) {

        if (FilesUtils.saveChart(generalAnchorPane, chart)) {
            DialogMessage.confirmMessage("Sauvegardé avec succés", 
                    "Le graphique a été sauvegardé avec succés.", 
                    "Le graphique a correctement été energistré dans "
                            + "le fichier spécifié.");
        } else {
            DialogMessage.errorMessage("Erreur !", 
                    "Erreur durant la sauvegarde.", 
                    "Une erreur est survenue durant la sauvegarde de votre "
                            + "image, veuillez ressayer.");
        }
    }

    /**
     * Save result in CSV file
     * @param event button click
     */
    @FXML
    private void saveToCsv(ActionEvent event) {

        if (FilesUtils.saveInCsv(anchorPaneExport, this.allStats)) {
            DialogMessage.confirmMessage("Sauvegardé avec succés", 
                    "Les résultats ont été sauvegardés avec succés.", 
                    "Les résultats sont enregistrés dans le fichier CSV spécifié.");
        } else {
            DialogMessage.errorMessage("Erreur !", 
                    "Erreur durant la sauvegarde.", 
                    "Une erreur est survenue durant la sauvegarde de votre "
                            + "fichier, veuillez ressayer.");
        }
    }

    /**
     * Save last generations
     * @param event
     */
    @FXML
    private void saveResults(ActionEvent event) {

        String name = null, filePath = null;
        Result result = null;

        if (CheckFields.isValid(textFieldSaveName)) {

            name = textFieldSaveName.getText().trim();
            try {
                filePath = DialogMessage.fileMessage(generalAnchorPane, chart);
            } catch (MalformedURLException e) {
                DialogMessage.errorMessage("Erreur !", 
                        "Erreur durant la sauvegarde.", 
                        "Impossible de sauvegarder ce résultat, "
                                + "veuillez ressayer.");
            }

            if (filePath != null) {
                result = new Result(name, filePath, this.allStats);
                /* add a new result */
                if (this.allResults.add(result)) {

                    FilesUtils.serialize(this.allResults);
                    this.allResults.setResults(FilesUtils.deserialize());

                    listViewMyData.getItems().clear();

                    /* Add saved result in list view */
                    for (int i = 0; i < this.allResults.getResults().size(); i++) {
                        listViewMyData.getItems().add("Génération : " + i + " : " 
                                + this.allResults.getResults().get(i).getSaveName());
                    }
                    
                    /* If saved result active list view */
                    if (listViewMyData.getItems().size() > 0) {
                        listViewMyData.setDisable(false);
                    }

                    DialogMessage.confirmMessage("Sauvegarde effectuée !", 
                            "Données sauvegardées avec succés", 
                            "Vous pouvez retrouver vos sauvegardes de "
                                    + "générations dans l'onglet 'Mes sauvegardes'");
                } else {
                    DialogMessage.errorMessage("Erreur !", 
                            "Erreur, nom existant.", 
                            "Impossible de sauvegarder ce résultat car une "
                                    + "sauvegarde possède déjà ce nom, "
                                    + "veuillez ressayer.");
                }
            }

        } else {
            DialogMessage.errorMessage("Erreur !", 
                    "Erreur, nom vide.", 
                    "Impossible de sauvegarder le résultat sans nom, "
                            + "veuillez ressayer.");
        }
    }

    /**
     * Open result
     * @param event
     */
    @FXML
    public void openResult(MouseEvent event) {

        int clickedIndex = listViewMyData.getSelectionModel().getSelectedIndex();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/Result.fxml"));

        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            ResultController controller = fxmlLoader.getController();

            controller.initialize(this.allResults.getResults().get(clickedIndex));
            stage.setScene(new Scene(root));
            stage.setTitle("Résultat numéro : " + clickedIndex);
            stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("../assets/home.png")));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a result
     * @param event
     */
    @FXML
    public void deleteResult(ActionEvent event) {

        String toDelete;

        if (CheckFields.isValid(textFieldNameToDelete)) {

            toDelete = textFieldNameToDelete.getText().trim(); 

            if (this.allResults.delete(toDelete)) {
                FilesUtils.serialize(this.allResults);
                this.allResults.setResults(FilesUtils.deserialize());

                listViewMyData.getItems().clear();

                /* Add saved result in list view */
                for (int i = 0; i < this.allResults.getResults().size(); i++) {
                    listViewMyData.getItems().add("Génération : " + i + " : " 
                            + this.allResults.getResults().get(i).getSaveName());
                }
                
                /* If saved result active list view */
                if (listViewMyData.getItems().size() < 1) {
                    listViewMyData.setDisable(true);
                }

                DialogMessage.confirmMessage("Succés", 
                        "Suppression effectuée", 
                        "La sauvegarde a été effectuée");
            } else {
                DialogMessage.errorMessage("Erreur !",
                        "Impossible de supprimer", 
                        "Impossible de supprimer l'enregistrement, "
                                + "veuillez réessayer.");
            }
        }
    }
}

