/*
 * ArraysAlgorithms.java                                      26 nov. 2020
 * No copyright, no right
 */
package fr._1irda.statistics.algorithms;

/**
 * Class with several sorting algorithms on arrays :
 * - insertion sort
 * - bubble sort
 * - optimized bubble sort
 * - comb sort
 * @author Adrien GARROUSTE
 */
public class ArraysAlgorithms {

    /**
     * Sort an array in ascending order
     * @param toSort array to sort
     * @return a sorted array in ascending order
     */
    public static double[] insertionSort(double[] toSort) {

        double toInsert;
        int place;

        for (int step = 1; step < toSort.length; step++) {
            toInsert = toSort[step];
            // search place to insert
            for (place = 0; toSort[place] < toInsert; place++);
            System.arraycopy(toSort, place, toSort, place + 1, step - place);
            toSort[place] = toInsert;
        }

        return toSort;
    }

    /**
     * Sort an array in ascending order
     * @param toSort array to sort 
     * @return a sorted array
     */
    public static double[] bubbleSort(double[] toSort) {

        double temp;

        for (int i = toSort.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (toSort[j + 1] < toSort[j]) {
                    temp = toSort[j + 1];
                    toSort[j + 1] = toSort[j];
                    toSort[j] = temp;
                }
            }
        }

        return toSort;
    }

    /**
     * Optimized bubble sort
     * @param toSort array to sort
     * @return a sorted array
     */
    public static double[] optimizedBubbleSort(double[] toSort) {

        boolean isSorted, notFinish = true;    
        double temp;

        for (int i = toSort.length - 1; i > 0 && notFinish; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (toSort[j + 1] < toSort[j]) {
                    temp = toSort[j + 1];
                    toSort[j + 1] = toSort[j];
                    toSort[j] = temp;
                    isSorted = false;
                }
            }

            if (isSorted) {
                notFinish = false;
            }
        }

        return toSort;
    }

    /**
     * Sort an array in ascending order
     * @param toSort array to sort
     * @return a sorted array
     */
    public static double[] combSort(double[] toSort) {

        int inter = toSort.length;
        boolean isSwap = true;
        int size = inter, i;
        double temp;

        while (inter > 1 || isSwap) {
            inter = (int) (inter / 1.3);

            if (inter < 1) {
                inter = 1;
            }

            i = 0;
            isSwap = false;

            while (i < size - inter) {
                if (toSort[i] > toSort[i + inter]) {
                    temp = toSort[i + inter];
                    toSort[i + inter] = toSort[i];
                    toSort[i] = temp;
                    isSwap = true;
                }
                i++;
            }
        }

        return toSort;
    }

    /**
     * Selection sort algorithm
     * @param toSort array to sort
     * @return a sorted array in ascending order
     */
    public static double[] selectionSort(double[] toSort) {

        int min;
        double temp;

        for (int i = 0; i < toSort.length - 1; i++) {

            min = i;       

            for (int j  = i + 1; j < toSort.length; j++) {
                if (toSort[j] < toSort[min]) {
                    min = j;
                }
            }

            if (min != i) {
                temp = toSort[i];
                toSort[i] = toSort[min];
                toSort[min] = temp;
            }
        }

        return toSort;
    }

    /**
     * Quick sort algorithm
     * @param toSort array to sort
     * @return a sorted array in ascending order
     */
    public static double[] quickSort(double[] toSort) {
        return null;
    }

    /**
     * Merge sort algorithm
     * @param toSort array to sort
     * @return a sorted array in ascending order
     */
    public static double[] mergeSort(double[] toSort) {
        return null;
    }
}