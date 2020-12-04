/*
 * TestArraysAlgorithms.java                                      1 déc. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr._1irda.statistics.algorithms.ArraysAlgorithms;
import fr._1irda.statistics.test_framework.AssertionTests;
import fr._1irda.statistics.utils.Generation;

/**
 * Test arrays algorithms
 * @author Adrien GARROUSTE
 */
public class TestArraysAlgorithms {

    /** Number of arrays generations */
    private static final int NUMBER_OF_GENERATIONS = 20;
    
    /** Array min size */
    private static final int ARRAY_MIN_SIZE = 1;

    /** Array max size */
    private static final int ARRAY_MAX_SIZE = 10000;
    
    /**
     * Shared image by different methods of tests
     */
    ArrayList<double[]> fixture = new ArrayList<>(List.of(
            new double[0],
            new double[] { 10.0 },
            new double[] { Double.MAX_VALUE },
            new double[] { -1.0, 10.0 },
            new double[] { 1.0, 2.0, 5.0, 7.0 },
            new double[] { -1.0, Double.MAX_VALUE, Double.MAX_VALUE, -1.0 },
            new double[] { Double.MAX_VALUE, 345.0, 10.0, 345.0, Double.MAX_VALUE },
            new double[] { 2.0, -5.0, 0.0, 6.0, 100.0, -10.0 },
            new double[] { 756.0, 65.0, 52.0, 10.0, 1.0, 0.0, -2.0, -5.0, -890.0 },
            new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 },
            new double[] { 87.0, 68.0, 51.0, 51.0, 45.0, 9.0, 5.0, 4.0, -7.0, -10.0 }
            ));

    /**
     * Test ascending insertion sort
     */
    public void testInsertionSort() {
        
        List<double[]> fixtureInsertionSort = List.of(
                new double[0],
                new double[] { 10.0 },
                new double[] { Double.MAX_VALUE },
                new double[] { -1.0, 10.0 },
                new double[] { 1.0, 2.0, 5.0, 7.0 },
                new double[] { -1.0, -1.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { 10.0, 345.0, 345.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { -10.0, -5.0, 0.0, 2.0, 6.0, 100.0 },
                new double[] { -890.0, -5.0, -2.0, 0.0, 1.0, 10.0, 52.0, 65.0, 756.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 }
                );
        
        System.out.print("Test insertion sort : ");
        
        for (int numTest = 0; numTest < fixtureInsertionSort.size(); numTest++) {
            ArraysAlgorithms.insertionSort(fixture.get(numTest));
            AssertionTests.assertionArraysEquals(fixtureInsertionSort.get(numTest), 
                    fixture.get(numTest), 
                    "Fail insertion sort"
                            + " fixture number : " 
                            + numTest + "\n");
        }
        
        System.out.println("All test passed");
    }

    /**
     * Test ascending bubble sort
     */
    public void testBubbleSort() {
        
        List<double[]> fixtureBubbleSort = List.of(
                new double[0],
                new double[] { 10.0 },
                new double[] { Double.MAX_VALUE },
                new double[] { -1.0, 10.0 },
                new double[] { 1.0, 2.0, 5.0, 7.0 },
                new double[] { -1.0, -1.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { 10.0, 345.0, 345.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { -10.0, -5.0, 0.0, 2.0, 6.0, 100.0 },
                new double[] { -890.0, -5.0, -2.0, 0.0, 1.0, 10.0, 52.0, 65.0, 756.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 }
                );
        
        System.out.print("Test bubble sort : ");
        
        for (int numTest = 0; numTest < fixtureBubbleSort.size(); numTest++) {
            ArraysAlgorithms.insertionSort(fixture.get(numTest));
            AssertionTests.assertionArraysEquals(fixtureBubbleSort.get(numTest), 
                    fixture.get(numTest), 
                    "Fail bubble sort"
                            + " fixture number : " 
                            + numTest + "\n");
        }
        
        System.out.println("All test passed");
    }

    /**
     * Test optimized bubble sort
     */
    public void testOptimizedBubbleSort() {
        
        List<double[]> fixtureOptimizedBubbleSort = List.of(
                new double[0],
                new double[] { 10.0 },
                new double[] { Double.MAX_VALUE },
                new double[] { -1.0, 10.0 },
                new double[] { 1.0, 2.0, 5.0, 7.0 },
                new double[] { -1.0, -1.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { 10.0, 345.0, 345.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { -10.0, -5.0, 0.0, 2.0, 6.0, 100.0 },
                new double[] { -890.0, -5.0, -2.0, 0.0, 1.0, 10.0, 52.0, 65.0, 756.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 }
                );
        
        System.out.print("Test optimized bubble sort : ");
        
        for (int numTest = 0; numTest < fixtureOptimizedBubbleSort.size(); numTest++) {
            ArraysAlgorithms.optimizedBubbleSort(fixture.get(numTest));
            AssertionTests.assertionArraysEquals(fixtureOptimizedBubbleSort.get(numTest), 
                    fixture.get(numTest), 
                    "Fail optimized bubble sort"
                            + " fixture number : " 
                            + numTest + "\n");
        }
        
        System.out.println("All test passed");
    }

    /**
     * Test ascending comb sort
     */
    public void testCombSort() {
        
        List<double[]> fixtureCombSort = List.of(
                new double[0],
                new double[] { 10.0 },
                new double[] { Double.MAX_VALUE },
                new double[] { -1.0, 10.0 },
                new double[] { 1.0, 2.0, 5.0, 7.0 },
                new double[] { -1.0, -1.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { 10.0, 345.0, 345.0, Double.MAX_VALUE, Double.MAX_VALUE },
                new double[] { -10.0, -5.0, 0.0, 2.0, 6.0, 100.0 },
                new double[] { -890.0, -5.0, -2.0, 0.0, 1.0, 10.0, 52.0, 65.0, 756.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 },
                new double[] { -10.0, -7.0, 4.0, 5.0, 9.0, 45.0, 51.0, 51.0, 68.0, 87.0 }
                );
        
        System.out.print("Test comb sort : ");
        
        for (int numTest = 0; numTest < fixtureCombSort.size(); numTest++) {
            ArraysAlgorithms.optimizedBubbleSort(fixture.get(numTest));
            AssertionTests.assertionArraysEquals(fixtureCombSort.get(numTest), 
                    fixture.get(numTest), 
                    "Fail optimized bubble sort"
                            + " fixture number : " 
                            + numTest + "\n");
        }
        
        System.out.println("All test passed");
    }

    /**
     * Test descending generation
     */
    @SuppressWarnings("static-method")
    public void testDescendingGeneration() {

        double[] generated;
        Random random = new Random();
        int size;
        
        System.out.print("Test descending order : ");

        for (int i = 0; i < NUMBER_OF_GENERATIONS; i++) {
            size = random.nextInt(ARRAY_MAX_SIZE - ARRAY_MIN_SIZE) + ARRAY_MIN_SIZE;
            generated = Generation.descendingGeneration(size);

            AssertionTests.assertionArrayDescendingOrder(generated, 
                    "Fail generated ascending order number : " + i);
        }
        
        System.out.println("All test passed");
    }
}
