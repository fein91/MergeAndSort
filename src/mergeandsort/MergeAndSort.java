/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeandsort;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author otatarik
 */
public class MergeAndSort {

    private enum SortionType {

        INSERTION, BUBLES, JAVA;
    }

    private final static int MAX_INT = 10000;
    private final static int ARRAY_SIZE = 1000;
    private final static int ARRAY_LEFT_SIZE = 5;
    private final static int ARRAY_RIGHT_SIZE = 10;

    private static int[] createMatrix(int size) {
        Random rnd = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = rnd.nextInt(MAX_INT);
        }
        return result;
    }

    private static void sortInsertion(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            if (array[i - 1] > array[i]) {
                int temp = array[i];
                int border = i;
//                int[] sorted = Arrays.copyOf(array, i);
//                int insertPos = Arrays.binarySearch(sorted, temp);
//
//                if (insertPos >= 0) {
//                } else {
//                    sorted = Arrays.copyOf(sorted, i+1);
//                    sorted[-1-insertPos] = temp;
//                }

                while (border != 0 && array[border] < array[border - 1]) {
                    array[border] = array[border - 1];
                    array[border - 1] = temp;
                    border--;
                }
            }
        }
    }

    private static void sortJava(int[] array) {
        Arrays.sort(array);
    }

    private static void sortBubles(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static long processSort(SortionType sortType, int[] array) {
        long stopTime = 0;
        long result = 0;
        long startTime = System.nanoTime();

        switch (sortType) {
            case INSERTION:
                sortInsertion(array);
                break;
            case BUBLES:
                sortBubles(array);
                break;
            case JAVA:
                sortJava(array);
                break;
        }

        stopTime = System.nanoTime();
        result = stopTime - startTime;
        return result;
    }

    private static int[] megreSorted(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int k = 0;
        int i = 0;
        int j = 0;

        while (true) {
            if (left.length == i) {
                System.arraycopy(right, j, result, k, right.length - j);
                break;
            } else if (right.length == j) {
                System.arraycopy(left, i, result, k, left.length - i);
                break;
            } else {
                if (left[i] > right[j]) {
                    result[k] = right[j];
                    j++;
                } else {
                    result[k] = left[i];
                    i++;
                }
            }
            k++;
        }
        return result;
    }

    private static void testSortions() {
        int[] a = createMatrix(ARRAY_SIZE);
        int[] b = Arrays.copyOf(a, ARRAY_SIZE);
        int[] c = Arrays.copyOf(a, ARRAY_SIZE);
        System.out.println(Arrays.toString(a));
        System.out.println("Bubles sort takes: " + processSort(SortionType.BUBLES, a) / 1000 + "ms");
        System.out.println("Java core sort takes: " + processSort(SortionType.JAVA, b) / 1000 + "ms");
        System.out.println("Insertion sort takes: " + processSort(SortionType.INSERTION, c) / 1000 + "ms");
        System.out.println(Arrays.toString(a));
    }

    private static void testMerge() {
        int[] left = createMatrix(ARRAY_LEFT_SIZE);
        int[] right = createMatrix(ARRAY_RIGHT_SIZE);

        processSort(MergeAndSort.SortionType.INSERTION, right);
        processSort(MergeAndSort.SortionType.INSERTION, left);

        System.out.println("Left: "+Arrays.toString(left));
        System.out.println("Right: "+Arrays.toString(right));

        int[] sorted = megreSorted(left, right);
        System.out.println("Result: "+Arrays.toString(sorted));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testSortions();
        //testMerge();

    }
}
