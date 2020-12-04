/*
 * Result.java                                      3 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Represent a saved test
 * A test represent one test with a chart and one or several generation(s)
 * @author Adrien GARROUSTE
 */
@SuppressWarnings("serial")
public class Result implements Serializable {
    
    /** Date where result was saved */
    private Date createdAt;
    
    /** Result name */
    private String saveName;
    
    /** Result image */
    private String imgPath;
    
    /** Statistics data */
    private Stat[] stats;
    
    /**
     * Constructor
     * @param saveName result name
     * @param imgPath chart image of result
     * @param stats results data
     */
    public Result(String saveName, String imgPath, Stat[] stats) {
        this.saveName = saveName;
        this.imgPath = imgPath;
        this.stats = stats;
        this.createdAt = new Date();
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the saveName
     */
    public String getSaveName() {
        return saveName;
    }

    /**
     * @return the img
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @return the stats
     */
    public Stat[] getStats() {
        return stats;
    }
}
