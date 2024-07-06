package com.demo.test;

import com.fasterxml.jackson.databind.JsonSerializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Coding {

    public static void main (String[] a) {
        int [] arr = {2,3,5,6,0,1};
        System.out.println(Arrays.toString(moveZeroes(arr)));

    }

    public static ArrayList<String> avgRating(ArrayList<ArrayList<String>> avgRanked) {
        return null;
    }

    public static int mostOccured(ArrayList<Integer> nums) {

        HashMap<Integer, Integer> seen = new HashMap<>();
        for (Integer num : nums) {
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        int mostOccurred = Integer.parseInt(null);

        for (int num : seen.keySet()) {
            int frequency = seen.get(num);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostOccurred = num;
            }
        }

        return mostOccurred;
    }


    // rotate array by d places

    public static void rotateArray(int[] nums,int n,int k) {

        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);

    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }

    // move zeroes to end

    public static int[] moveZeroes (int[] arr) {
        int n = arr.length;
        int j = -1;
        int k = 0;

        for (int i = 0 ; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
            }
        }

        if (j == - 1) {
            return arr;
        }

        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j ++;
            }
        }
        return arr;
    }

    // remove dupes from sorted array

    public static int removeDupesFromSorted(int[] arr){
        int n = arr.length;
        int i = 0;
        for ( int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
        }

    // Kadane's algo

    public static int longestSubarray(int [] arr) {
        int n = arr.length;

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : arr) {
            currSum += num;
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    // longest SubArray Sum Length(positive)

    public static int lengthOfLongestSubarrayWithMaxSum(int[] arr) {
        int n = arr.length;

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currLength = 0;
        int maxLength = 0;

        for (int num : arr) {
            currSum += num;
            currLength++;

            if (currSum > maxSum) {
                maxSum = currSum;
                maxLength = currLength;
            } else if (currSum == maxSum) {
                maxLength = Math.max(maxLength, currLength);
            }

            if (currSum < 0) {
                currSum = 0;
                currLength = 0;
            }
        }
        return maxLength;
    }

    // todo: V IMP Longest subarray length (neg + pos)

    public static int longestSubarrayNeg(int[] arr, int k) {
        int n = arr.length;
        int currSum = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < n; i ++) {
            currSum += arr[i];

            if (currSum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = currSum - k;

            if (sumMap.containsKey(rem)){
                int len = i - sumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!sumMap.containsKey(currSum)){
                sumMap.put(currSum, i);
            }
        }
        return maxLen;
    }


    // sort an array of 0, 1, 2s

    public static int[] sortFrequency( int[] arr) {
        int n = arr.length;
        int x = 0;
        int y = 0;
        int z = 0;
        for (int j : arr) {
            if (j == 0) {
                x++;
            }
            if (j == 1) {
                y++;
            }
            if (j == 2) {
                z++;
            }
        }
        int [] num = new int[n];
        for (int i = 0; i < x; i ++) {
            num[i] = 0;
        }
        for (int i = x + 1; i < y; i ++) {
            num[i] = 1;
        }
        for (int i = z + 1; i < n; i ++) {
            num[i] = 2;
        }

        return num;
    }

    // majority element n//2

    public static int majorityElement(int[] arr) {
        int n = arr.length;

        int count = 0;
        int ele = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                ele = arr[i];
                count = 1;
            }
            else if (ele == arr[i]){
                count ++;
            }
            else {
                count --;
            }
        }

        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele) {
                count2 ++;
            }
        }

        if (count2 > n/2) {return ele;}
        else {return -1;}
    }

    // best time to buy stock

    public static int maxProfit(int[] arr) {
        int maxProf = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            int profit = arr[i] - minPrice;
            maxProf = Math.max(maxProf, profit);
        }

        return maxProf;
    }


    // largest subarray with 0 sum

    public static int largestZeroSubarray(int [] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int currSum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i ++) {
            currSum += arr[i];

            if (currSum == 0) {
                maxLen = Math.max(i+1, maxLen);
            } else {
                if (map.get(currSum) != null) {
                    maxLen = Math.max(maxLen, i - map.get(currSum));
                }
                else {
                    map.put(currSum, i);
                }
            }
        }

        return maxLen;
    }

    // todo: Binary Search
    // floor ceil

    public static int getFloor(int[] arr, int x) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;
        int ans = - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int getCeil(int[] arr, int x) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;
        int ans = - 1;

        while (left >= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= x) {
                ans = arr[mid];
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    //

}


