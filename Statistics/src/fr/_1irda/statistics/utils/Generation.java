/*
 * Generation.java                                      26 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.utils;

import java.util.Random;

/**
 * Class to generate array in :
 * - descending order
 * - random order
 * @author Adrien GARROUSTE
 */
public class Generation {

    /** Max value in array */
    private static final double MAX_VALUE = 9999999.99;

    /** Max space between number in descending generation */
    private static final int SPACING = 25000;

    /**
     * Generate an array in descending order
     * @param size of array to generate
     * @return a generated array with descending values
     */
    public static double[] descendingGeneration(int size) {

        Random random = new Random();
        double randomNumber;
        double[] generated = new double[size];

        randomNumber = random.nextDouble() * MAX_VALUE;

        for (int i = 0; i < size; i++) {
            System.out.println(randomNumber);
            generated[i] = randomNumber;
            randomNumber -= random.nextDouble() * SPACING;
        }

        return generated;
    }

    /**
     * Generate an array with random values
     * @param size array size
     * @return an array with random values
     */
    public static double[] randomGeneration(int size) {

        Random random = new Random();
        double[] generated = new double[size];       

        for (int i = 0; i < size; i++) {
            generated[i] = random.nextDouble() * MAX_VALUE
                    - random.nextDouble() * MAX_VALUE;
        }

        return generated;
    }
}
