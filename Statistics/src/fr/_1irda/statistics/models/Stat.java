/*
 * Stat.java                                      1 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.models;

import java.io.Serializable;
import java.lang.reflect.Method;

import fr._1irda.statistics.algorithms.ArraysAlgorithms;
import fr._1irda.statistics.utils.ExtractAlgorithm;
import fr._1irda.statistics.utils.Generation;

/**
 * Represent one test with one algorithm with two generation
 * @author Adrien GARROUSTE
 */
@SuppressWarnings("serial")
public class Stat implements Serializable {

    /** Random values generation */
    private double[] values;

    /** Size of array */
    private int size;

    /** Sorting time of descending generation in seconds */
    private double sortingTime;

    /** Chosen sort algorithm */
    private String sortAlgorithm;

    /** Chosen generation algorithm */
    private String generationAlgorithm;
    
    /** Generation name before modification */
    private String beforeUpdateGeneration;
    
    /** Sorting algorithm name before modification */
    private String beforeUpdateSortAlgo;

    /**
     * Constructor
     * @param sortAlgorithm sorting algorithm 
     * @param generation generation algorithm
     * @param size array size
     */
    public Stat(String sortAlgorithm, String generation, int size) {
        this.sortAlgorithm = ExtractAlgorithm.getSortingAlgorithm(sortAlgorithm);
        this.generationAlgorithm = ExtractAlgorithm.getGenerationAlgorithm(generation);
        this.size = size;
        this.sortingTime = 0.0;
        this.values = new double[size];
        this.beforeUpdateGeneration = generation;
        this.beforeUpdateSortAlgo = sortAlgorithm;
    }

    /**
     * Make statistics on arrays
     */
    public void compute() {

        Method toInvoke;
        double stop, start;
        Object generated;
        
        /* call dynamically the generation algorithm */
        try {
            toInvoke = Generation.class.getDeclaredMethod(this.generationAlgorithm, int.class);
            generated = toInvoke.invoke(null, this.size);
            this.values = (double[]) generated;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        /* call sorting algorithm and compute time */
        start = System.currentTimeMillis();
        try {
            /* Call dynamically method */
            toInvoke = ArraysAlgorithms.class.getDeclaredMethod(this.sortAlgorithm, double[].class);
            toInvoke.invoke(null, this.values);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();
        this.sortingTime = (stop - start) / 1000;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the sortingTime
     */
    public double getSortingTime() {
        return sortingTime;
    }

    /**
     * @return the values
     */
    public double[] getValues() {
        return values;
    }

    /**
     * @return the beforeUpdateGeneration
     */
    public String getBeforeUpdateGeneration() {
        return beforeUpdateGeneration;
    }   
    
    /**
     * @return the beforeUpdateGeneration
     */
    public String getBeforeUpdateSortAlgo() {
        return beforeUpdateSortAlgo;
    }   
}
