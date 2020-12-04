/*
 * Statistics.java                                      30 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.models;

import java.util.Random;

/**
 * Launch statistics with selected algorithms 
 * with descending and random generation
 * @author Adrien GARROUSTE
 */
public class Statistics {

    /** Temporary array max size */
    private static final int TEMP_SIZE = 4;

    /** Total time of statistics */
    private double totalSortingTime;

    /** Number of stats to make */
    private int nbTest;

    /** Size of arrays ot sort */
    private int arraySize;

    /** Chosen sorting algorithm */
    private String sortAlgorithm;

    /** Chosen generation algorithm */
    private String generationAlgorithm;
    
    /** Arrays with statistics */
    private Stat[] stats;

    /**
     * Make statistics on set on arrays 
     * @param arraySize size of arrays to sort (if < 1, random size)
     * @param nbTest number of tests to make
     * @param algorithm sorting algorithm to apply of set of arrays
     * @param generation arrays generation
     */
    public Statistics(String algorithm, String generation, int arraySize, int nbTest) {
        this.sortAlgorithm = algorithm;
        this.generationAlgorithm = generation;
        this.arraySize = arraySize;
        this.nbTest = nbTest;
        this.totalSortingTime = 0.0;
        this.stats = new Stat[this.nbTest];
    }

    /**
     * Launch statistics 
     */
    public void launch() {

        Random rand = new Random();
        int size = TEMP_SIZE;

        for (int i = 0; i < this.nbTest; i++) {
            
            if (this.arraySize < 1) {  
                size += rand.nextInt(75 - 1) + 1;                
            } else {
                size = this.arraySize;
            }

            this.stats[i] = new Stat(this.sortAlgorithm, this.generationAlgorithm, size);
            this.stats[i].compute();
            this.totalSortingTime += this.stats[i].getSortingTime();
        }
    }

    /**
     * @return the statistics
     */
    public Stat[] getStats() {
        return stats;
    }

    /**
     * @return the totalSortingTime
     */
    public double getTotalSortingTime() {
        return totalSortingTime;
    } 
}
