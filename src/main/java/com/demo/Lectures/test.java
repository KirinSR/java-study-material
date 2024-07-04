package com.demo.Lectures;

import org.apache.kafka.common.protocol.types.Field;

import java.util.ArrayList;

public class test {

//    find palindrom from string (bananas)
    public static void main (String a[]) {

        System.out.println("All combination : " + palindromeComb("bananas"));
    }

    // take out all the possible palindromes from the word
    public static boolean isPalindrom(String word) {
        // 3 min len
        // bananas -> ana, ana, anana
        // reverse the string char == string char

        int n = word.length();
        int left = 0;
        int right = n - 1;

        while (left < right){
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            left += 1;
            right -= 1;
        }
        return true;
    }

    public static ArrayList<String> palindromeComb (String word) {
        ArrayList<String> res = new ArrayList<>();
        int n = word.length();

        for (int i = 0; i <= n; i++) {
            for (int j = i+3; j <= n; j++) {

                String sub = word.substring(i,j);
//                System.out.println(sub);
                if (isPalindrom(sub)) {
                    res.add(sub);
                }
            }
        }

        return res;
    }
}


/*

attendance Table
empId
empDept
empDate
isPresent


Find employees who are absent for more than 3 days



 */

