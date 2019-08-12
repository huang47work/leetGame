package com.mason.leetcode;

/**
 * Created by huang_sq on 2019/8/12.
 */
public class FindOrInsertSortedArray {


    public static int searchInsert(int[] nums, int target) {

        if (nums.length == 0 || nums[0] > target) {

            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }

            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 5, 8, 9};

        System.out.println(searchInsert(array, 6));


    }


}
