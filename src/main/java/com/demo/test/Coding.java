package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;

public class Coding {

    public static void main (String[] a) {

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
}
