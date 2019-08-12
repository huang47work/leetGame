package com.mason.leetcode;

/**
 * Created by huang_sq on 2019/8/8.
 */
public class SubStringMatch {

    public static boolean fuckToMuchTime(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        int middle = s.length() / 2;
        for (int i = middle - 1; i >= 0; i--) {
            String str = s;
            String sub = str.substring(0, i + 1);
            if (s.split(sub).length == 0) {
                return true;
            }
            if (i == 0) {
                return false;
            }
        }
        return false;
    }


    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        String doubleStr = s + s;
        return doubleStr.substring(1, doubleStr.length() - 1).contains(s);
    }


    public static void main(String[] args) {
//        System.out.println(repeatedSubstringPattern("ababab"));


    }
}
