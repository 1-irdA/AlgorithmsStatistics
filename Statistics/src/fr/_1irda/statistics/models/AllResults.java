/*
 * AllResults.java                                      3 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.models;

import java.util.ArrayList;

/**
 * TODO comment class responsibility
 * @author Adrien GARROUSTE
 */
public class AllResults {
    
    /**
     * Contains all saved results
     */
    private ArrayList<Result> results;
    
    /**
     * Constructor
     * @param results all saved result
     */
    public AllResults(ArrayList<Result> results) {
        this.results = results;
    }
    
    /**
     * Add a result
     * @param toAdd result to add
     */
    public void add(Result toAdd) {
        this.results.add(toAdd);
    }

    /**
     * @return the results
     */
    public ArrayList<Result> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(ArrayList<Result> results) {
        this.results = results;
    } 
    
}
