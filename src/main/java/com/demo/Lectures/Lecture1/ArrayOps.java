package com.demo.Lectures.Lecture1;

public class ArrayOps {


    public static void main (String[] a) {

    }

    // swap each and every value to get the sorted
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i; j < arr.length; j++) {
                int temp = arr[i];
                arr[i] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    // sort the first n-1 element last one will automatically be sorted
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int min = 0;
        for (int i = 0; i < n; i++){
            min = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < min){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            int j = i-1;
            while(j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = val;
        }
    }

    // find min
    public static int findMin(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    
// binary sort
    public static int binarySearch(int[] arr, int target){
        int n = arr.length;
        insertionSort(arr);
        int left = 0;
        int right = n-1;

        while(left < right){
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            else if (target > arr[mid]) {
                left = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

}

