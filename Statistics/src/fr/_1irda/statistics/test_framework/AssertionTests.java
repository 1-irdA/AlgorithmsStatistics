/*
 * AssertionTests.java                                      25 nov. 2020
 * L3 MIASHS option MIAGE IUT of Rodez 2020-2021
 * No copyright, no right
 */
package fr._1irda.statistics.test_framework;

import java.util.Arrays;

/**
 * Tests assertion to compare expected results with obtained results
 * @author Adrien GARROUSTE
 */
public class AssertionTests {

    /** 
     * Throw custom exception to explain error
     * @param message error explained
     */
    public static void fail(String message) {
        throw new FailTest("\n" + message);
    }


    /**
     * Test assertion with launch FailTest if assertion is not verified
     * @param expected expected result
     * @param toTest obtained result to compare with expected
     * @param message explain number of test and fail 
     * @throws FailTest if assertion is false
     */
    public static void assertionArraysEquals(double[] expected, double[] toTest, String message) {
        if (!Arrays.equals(expected, toTest)) {
            fail(message + "Differents arrays\n"
                    + Arrays.toString(expected)
                    + "\nand \n" + Arrays.toString(toTest));
        }
    }

    /**
     * Test if a dynamic array is in descending order
     * @param toTest array to analyze
     * @param message explain error
     */
    public static void assertionArrayDescendingOrder(double[] toTest, String message) {
        for (int i = 0; i < toTest.length - 1; i++) {
            if (toTest[i] < toTest[i + 1]) {
                fail(message);
            }
        }
    }
}
