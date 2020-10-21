package com.wen.util;

public class MyArrays {

    public static <T> void reverse(T[] a) {
        int i = 0, j = a.length;
        T temp;

        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    public static void reverse(int[] a) {
        reverse(a, 0, a.length);
    }
    public static void reverse(int[] a, int start, int end) {
        int i = start, j = end - 1;
        int temp;

        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }
    }

}
