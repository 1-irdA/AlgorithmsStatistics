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
     * @return true if added
     */
    public boolean add(Result toAdd) {
        
        boolean added = true;
        
        if (this.isUnique(toAdd.getSaveName())) {
            this.results.add(toAdd);
        } else {
            added = false;
        }
        
        return added;
    }
    
    /**
     * Determine if a name is not already saved
     * @param name to check
     * @return true if not save
     */
    public boolean isUnique(String name) {
        
        boolean isUnique = true;
        
        for (int i = 0; i < this.results.size() && isUnique; i++) {
            if (this.results.get(i).getSaveName().equals(name)) {
                isUnique = false;
            }
        }
        
        return isUnique;
    }
    
    /**
     * Delete a result
     * @param toDelete result to delete
     * @return true if deleted
     */
    public boolean delete(String toDelete) {
        
        boolean deleted = false;
        
        for (int i = 0; i < this.results.size() && !deleted; i++) {
            if (this.results.get(i).getSaveName().equals(toDelete)) {
                this.results.remove(i);
                deleted = true;
            }
        }
        
        return deleted;
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
