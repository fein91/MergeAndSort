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

    private final static int MAX_INT = 10000;

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

        for (int i = 0; i < size; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i + 1];
                int insertPosition = Arrays.binarySearch(Arrays.copyOfRange(array, 0, i), temp);

            }
        }
    }

    // 7 5 6 9 1 0
    //   |
    // 5 7 6 9 1 0
    //     |
    // 5 6 7 9 1 0
    //       |
    // 5 6 7 9 1 0
    //         |
    // 1 5 6 7 9 0
    //           |
    // 0 1 5 6 7 9
    private static long sortMegreJava(int[] array) {
        long startTime = System.nanoTime();
        long stopTime;
        Arrays.sort(array);
        stopTime = System.nanoTime();
        return stopTime - startTime;
    }

    private static long sortBubles(int[] array) {
        int size = array.length;
        Calendar cal = Calendar.getInstance();
        long stopTime;
        long startTime = System.nanoTime();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        stopTime = System.nanoTime();
        return stopTime - startTime;
    }
    //  |
    // [5,4,7,1,8,2]
    //    |
    // [4,5,7,1,8,2]
    //      |
    // [4,5,7,1,8,2]
    //        |
    // [4,5,1,7,8,2]
    //          |
    // [4,5,1,7,2,8]

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = createMatrix(10000);
        int[] b = Arrays.copyOf(a, 10000);
        //System.out.println(Arrays.toString(a));
        System.out.println("Bubles sort takes: " + sortBubles(a));
        System.out.println("Java core sort takes: " + sortMegreJava(b));
        //System.out.println(Arrays.toString(a));

    }

}
