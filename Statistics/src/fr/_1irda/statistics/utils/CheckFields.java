/*
 * CheckFields.java                                      1 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.utils;

import javafx.scene.control.TextField;

/**
 * Check input fields
 * @author Adrien GARROUSTE
 */
public class CheckFields {
    
    /** Min of arrays generations */
    private static final int MIN_NB_GENERATIONS = 1;
    
    /** Max of arrays generations */
    private static final int MAX_NB_GENERATIONS = 2600;

    /**
     * Determine if text field are valid
     * @param textFieldArraySize text field to input array size
     * @param textFieldNbTests text field to input number of tests
     * @return true if valid
     */
    public static boolean isValid(TextField textFieldArraySize, 
            TextField textFieldNbTests) {

        int arraySize, nbTest;
        boolean isValid = true;

        if (!textFieldArraySize.getText().isBlank() 
                && !textFieldNbTests.getText().isBlank()) {

            try {
                arraySize = Integer.parseInt(textFieldArraySize.getText().trim());
                nbTest = Integer.parseInt(textFieldNbTests.getText().trim());

                if (arraySize > Integer.MAX_VALUE 
                        || nbTest < MIN_NB_GENERATIONS
                        || nbTest > MAX_NB_GENERATIONS) {
                    isValid = false;
                }

            } catch (NumberFormatException e) {
                isValid = false;
            }
        }

        return isValid;
    }
    
    /**
     * Check if text field content is valid
     * @param toCheck text field to verify
     * @return true if valid
     */
    public static boolean isValid(TextField toCheck) {
        return !toCheck.getText().isBlank();
    }
}
