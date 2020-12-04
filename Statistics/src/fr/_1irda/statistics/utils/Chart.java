/*
 * Chart.java                                      2 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.utils;

import fr._1irda.statistics.models.Stat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 * Make chart with statistics
 * @author Adrien GARROUSTE
 */
public class Chart {

    /** Chart */
    private LineChart<String, Double> lineChart;
    
    /** X axis */
    private CategoryAxis xAxis;

    /** Y axis */
    private NumberAxis yAxis;
    
    /** Array who contains all computed stats */
    private Stat[] stats;

    /**
     * Constructor
     * @param chart chart to display
     * @param xAxis category axis
     * @param yAxis number axis
     * @param stats all effectued stats
     */
    public Chart(LineChart<String, Double> chart,
            CategoryAxis xAxis, 
            NumberAxis yAxis,
            Stat[] stats) {
        
        this.lineChart = chart;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.stats = stats; 
        
        this.lineChart.getData().clear();
        this.lineChart.setLegendVisible(false);
        this.lineChart.setCreateSymbols(false);
        this.xAxis.setLabel("Taille des tableaux");
        this.yAxis.setLabel("Temps de tri en secondes");
        
        this.lineChart.setVisible(true);
        this.xAxis.setVisible(true);
        this.yAxis.setVisible(true);
    }

    /**
     * Build chart with sorting result
     */
    public void makeChart() {

        ObservableList<String> xAxisElements = FXCollections.observableArrayList(); 
        XYChart.Series<String, Double> series = new Series<String, Double>();
        int size;

        for (int i = 0; i < this.stats.length; i++) {
            size = this.stats[i].getSize();

            // when one array, add one same size
            if (!xAxisElements.contains(size + "")) {
                xAxisElements.add(size + "");
            }

            series.getData()
            .add(new Data<String, Double>(this.stats[i].getSize() + "", 
                    this.stats[i].getSortingTime()));
        }

        xAxis.setCategories(xAxisElements);

        lineChart.getData().add(series);
    }
}
