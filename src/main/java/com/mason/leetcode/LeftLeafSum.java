package com.mason.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang_sq on 2019/8/8.
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 因为左叶子这个需要 所以 用两个list进行遍历吧
 */
public class LeftLeafSum {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //稍微递归一下就可以了
        Integer sum = 0;
        List<TreeNode> rootList = new ArrayList<>();
        List<TreeNode> rightList = new ArrayList<>();
        rightList.add(root);
        return findLeftLeafAndSum(rootList, rightList, sum);
    }

    private static int findLeftLeafAndSum(List<TreeNode> leftList, List<TreeNode> rightList, Integer sum) {

        if (leftList.size() == 0 && rightList.size() == 0) {
            return sum;
        }
        List<TreeNode> nextLevelLeftList = new ArrayList<>();
        List<TreeNode> nextLevelRightList = new ArrayList<>();

        //遍历左边子节点
        for (TreeNode leftNode : leftList) {
            if (leftNode.left == null && leftNode.right == null) {
                sum += leftNode.val;
            } else {
                if (leftNode.left != null) {
                    nextLevelLeftList.add(leftNode.left);

                }
                if (leftNode.right != null) {
                    nextLevelRightList.add(leftNode.right);
                }
            }
        }


        for (TreeNode rightNode : rightList) {
            if (rightNode.left != null) {
                nextLevelLeftList.add(rightNode.left);

            }
            if (rightNode.right != null) {
                nextLevelRightList.add(rightNode.right);
            }


        }
        return findLeftLeafAndSum(nextLevelLeftList, nextLevelRightList, sum);

    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

}







