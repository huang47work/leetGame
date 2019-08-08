package com.mason.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by huang_sq on 2019/8/8.
 */
public class BinaryWatch {

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));

    }


    /**
     * 例如，上面的二进制手表读取 “3:25”。
     * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
     *
     * 例:
     *
     * 输入: n = 1
     * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     *
     *
     * 注意事项:
     *
     * 输出的顺序没有要求。
     * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
     * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-watch
     *
     *
     * 小时的可能性是 1 2 4 8   范围是 0 - 11  亮灯的可能性只有三个灯  亮灯三个里面还需要剔除 8+4+2 和 8+4+1
     * 分钟的可能性是 1 2 4 8 16 32 至多也就5个灯 5个灯的可能性里 还需要排除 32+16+8+4+1 和 32+16+8+4+2
     * 综上 n<=8
     */
    public static List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        //直接遍历  0:00 -> 12:00   每个时间有多少1
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count1(i) + count1(j) == num) {
                    System.out.println(" i : " + i + "  " + " j : " + j);
                    res.add(i + ":" + (j < 10 ? "0" + j : j));
                }


            }
        }
        return res;
    }

    /**
     * 计算二进制中1的个数
     * @param n
     * @return
     */
    static int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }

        return res;
    }

}
