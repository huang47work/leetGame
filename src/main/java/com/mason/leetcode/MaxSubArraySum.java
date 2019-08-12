package com.mason.leetcode;

/**
 * Created by huang_sq on 2019/8/12.
 */
public class MaxSubArraySum {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
/*    public int maxSubArray(int[] nums) {
        //我先用(近似)穷举的方式
        //这个子列无论如何 肯定是首尾两个正数
        //那么把所有的正数作为桩 求各个子列的和 返回
        //码的太复杂了 还要记住各个子列 比较maxSum之后再返回

        //有没有更好的办法
        return 0;
    }*/

    /**
     * 此为动态规划 怎么理解
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] tets = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(tets));

    }
}
