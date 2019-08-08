package com.mason.leetcode;

/**
 * Created by huang_sq on 2019/8/8.
 */
public class LeftLeafSumBetter {

    static Integer sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return sum;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode bottom = new TreeNode(15);
        TreeNode bottom2 = new TreeNode(7);

        TreeNode middle = new TreeNode(9);
        TreeNode middle2 = new TreeNode(20);

        TreeNode root = new TreeNode(3);

        middle2.left = bottom;
        middle2.right = bottom2;

        root.left = middle;
        root.right = middle2;

        System.out.println(sumOfLeftLeaves(root));

    }
}





 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

