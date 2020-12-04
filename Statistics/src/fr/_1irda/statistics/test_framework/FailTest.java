/*
 * FailTest.java                                      25 nov. 2020
 * L3 MIASHS option MIAGE IUT of Rodez 2020-2021
 * No copyright, no right
 */
package fr._1irda.statistics.test_framework;

/**
 * TODO comment class responsibility
 * @author Adrien GARROUSTE
 */
@SuppressWarnings("serial")
public class FailTest extends RuntimeException {
    
    /**
     * Default constructor
     */
    public FailTest() { }

    /**
     * Constructor
     * @param message message details
     */
    public FailTest(String message) {
        super(message);
    }
}
