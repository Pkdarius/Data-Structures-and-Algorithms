package com.haitd22.dsa._3._1._3;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        int[] data = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < 10; i++) {
            data[i] = rand.nextInt(100);
        }

        int[] origin = Arrays.copyOf(data, data.length);
        System.out.println("Array equal before sort: " + Arrays.equals(data, origin));
        Arrays.sort(data);
        System.out.println("Array equal after sort: " + Arrays.equals(data, origin));
        System.out.println("Origin: " + Arrays.toString(origin));
        System.out.println("Data:  " + Arrays.toString(data));
    }
}
