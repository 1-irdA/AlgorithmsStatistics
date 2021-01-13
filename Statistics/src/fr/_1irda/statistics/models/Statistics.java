/*
 * Statistics.java                                      30 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.models;

/**
 * Launch statistics with selected algorithms 
 * with descending and random generation
 * @author Adrien GARROUSTE
 */
public class Statistics {
    
    /** Spacing between size */
    private static final int SPACING = 50;

    /** Total time of statistics */
    private double totalSortingTime;

    /** Number of statistic to make */
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

        int size = SPACING;

        for (int i = 0; i < this.nbTest; i++) {
            
            if (this.arraySize < 1) {  
                size += SPACING;       
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
        return this.stats;
    }

    /**
     * @return the totalSortingTime
     */
    public double getTotalSortingTime() {
        return this.totalSortingTime;
    } 
}
