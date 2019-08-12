package com.mason.leetcode;

/**
 * Created by huang_sq on 2019/8/12.
 */
public class FindSubStr {



    /*char[] source, int sourceOffset, int sourceCount,
    char[] target, int targetOffset, int targetCount,
    int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            *//* Look for first character. *//*
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            *//* Found first character, now look at the rest of v2 *//*
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    *//* Found whole string. *//*
                    return i - sourceOffset;
                }
            }
        }
        return -1;*/


    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));

    }

    /**
     * "mississippi"
     * "issipi"
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        char[] sourceChars = haystack.toCharArray();
        char[] targetChars = needle.toCharArray();
        for (int i = 0; i < sourceChars.length; i++) {
            int matchIndex;
            if (sourceChars[i] == targetChars[0]) {
                matchIndex = i;

                //开始遍历目标字符串
                for (int j = 0; j < targetChars.length; j++) {
                    if (matchIndex + j < sourceChars.length) {
                        if (targetChars[j] != sourceChars[matchIndex + j]) {
                            break;
                        }
                    } else {
                        return -1;
                    }
                    if (j == targetChars.length - 1) {
                        return matchIndex;
                    }
                }
            }
        }
        return -1;
    }


}
