/*
 * ExtractAlgorithm.java                                      2 d�c. 2020
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
        case "Tri par insertion":
            algorithm = "insertionSort";
            break;
        case "Tri � bulles":
            algorithm = "bubbleSort";
            break;
        case "Tri � bulles optimis�":
            algorithm = "optimizedBubbleSort";
            break;
        case "Tri au peigne":
            algorithm = "combSort";
            break;
        default:
            throw new IllegalArgumentException("Unexpected value: " + toAnalyze);
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
        case "Al�atoire": 
            algorithm = "randomGeneration";
            break;
        case "Descendante":
            algorithm = "descendingGeneration";
            break;
        default:
            throw new IllegalArgumentException("Unexpected value: " + toAnalyse);
        }
        
        return algorithm;
    }
}
