/*
 * ExtractAlgorithm.java                                      2 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.utils;

/**
 * Return correct algorithm name
 * @author Adrien GARROUSTE
 */
public class ExtractAlgorithm {

    /**
     * Return algorithm name in ArraysAlgorithm class
     * @param toAnalyze no formatted algorithm name
     * @return formatted algorithm name
     */
    public static String getSortingAlgorithm(String toAnalyze) {

        String algorithm;

        switch (toAnalyze) {
        case "Tri par insertion" -> algorithm = "insertionSort";
        case "Tri à bulles" -> algorithm = "bubbleSort";
        case "Tri à bulles optimisé" -> algorithm = "optimizedBubbleSort";
        case "Tri à peigne" -> algorithm = "combSort";
        case "Tri par sélection" -> algorithm = "selectionSort";
        default -> throw new IllegalArgumentException("Unexpected value: " 
                + toAnalyze);
        }

        return algorithm;
    }

    /**
     * Return algorithm name in Generation class
     * @param toAnalyse no formatted algorithm name
     * @return generation algorithm name
     */
    public static String getGenerationAlgorithm(String toAnalyse) {
        String algorithm;

        switch (toAnalyse) {
        case "Aléatoire" -> algorithm = "randomGeneration";
        case "Descendante" -> algorithm = "descendingGeneration";
        case "Ascendante" -> algorithm = "ascendingGeneration";
        default -> throw new IllegalArgumentException("Unexpected value: " 
                + toAnalyse);
        }

        return algorithm;
    }
}
