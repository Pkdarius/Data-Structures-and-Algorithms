package com.haitd22.dsa._3._1._2;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            int currentChar = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > currentChar) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = currentChar;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random rd = new Random();
        for (int i = 0; i < 1000000; i++) {
            arr[i] = rd.nextInt(10000000);
        }
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
