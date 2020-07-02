package first;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Recursion {


    public static void main(String[] args) {

        int[] a = {1, 3, 4, 8, 9, 1, 2, 4, 0, 7, 6};
        int[] sortedArray = {0, 1, 1, 2, 3, 4, 4, 6, 7, 8, 9};
        //                        bubbleSort(a);

        //        insertSort(a);

        //        findRoot("3", 7);
        int value = 4;
        /*int index = binarySearchFirstMin(sortedArray, value);
        if (index > 0) {
            System.out.println("第一个大于等于" + value + "的元素是下表为" + index + "的元素" + sortedArray[index]);
        } else {
            System.out.println("找不到你要的元素哦");
        }*/


        int index = binarySearchLastMin(sortedArray, value);
        if (index > 0) {
            System.out.println("最后一个小于等于" + value + "的元素是下表为" + index + "的元素" + sortedArray[index]);
        } else {
            System.out.println("找不到你要的元素哦");
        }


    }

    private static void bubbleSort(int[] a) {

        int length = a.length;

        for (int i = 0; i < length; i++) {
            int temp;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int k = 0; k < a.length; k++) {
            System.out.print(" " + a[k]);
        }
        System.out.printf("\n");

    }

    private static void insertSort(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }

        for (int k = 0; k < a.length; k++) {
            System.out.print(" " + a[k]);
        }
        System.out.printf("\n");


    }

    /**
     * 找平方根 精确到n位
     * 精确到某一位 不是舍弃某一位
     * 精确到小数点后两位 则代表着 0.013 -> 0.01
     * 精确到小数点后两位 则代表着 0.016 -> 0.02
     * 此处的精确到 就是循环的退出条件
     * (a-mid)~2 <= accuracy~2
     */
    private static void findRoot(String a, int n) {
        BigDecimal origin = new BigDecimal(a);
        BigDecimal low = new BigDecimal("0");
        BigDecimal high = new BigDecimal(a);
        BigDecimal accuracy = new BigDecimal("1"); //精确到位数
        for (int i = 1; i <= n; i++) {
            accuracy = accuracy.multiply(new BigDecimal("0.1"));
        }
        BigDecimal mid = (high.add(low)).divide(new BigDecimal("2"));
        while (mid.multiply(mid).subtract(origin).abs().compareTo(accuracy) > 0) {
            if (mid.multiply(mid).compareTo(origin) > 0) {
                high = mid;
            } else {
                low = mid;
            }
            mid = high.add(low).divide(new BigDecimal("2"));
        }
        System.out.println(a + "的平方根=" + mid.setScale(n, RoundingMode.UP));
    }

    /**
     * 二分查找第一个大于给定数value的元素
     * @param a 数组
     * @param value 给定的数
     *             此处给的数组有序 , 但是有重复的元素
     */
    private static int binarySearchFirstMin(int[] a, int value) {
        int length = a.length;
        int low = 0;
        int high = length - 1;

        //边界判断
        if (a[low] >= value) {
            return low;
        } else if (a[high] < value) {
            return -1;
        }

        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (a[mid] >= value && a[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }


    /**
     * 二分查找最后一个元素小于给定数value的元素
     * @param a 数组
     * @param value 给定的数
     *             此处给的数组有序 , 但是有重复的元素
     */
    private static int binarySearchLastMin(int[] a, int value) {
        int length = a.length;
        int low = 0;
        int high = length - 1;

        //边界判断
        //最大的都比它小
        if (a[high] < value) {
            return high;
        //最小都比它大
        } else if (a[low] >= value) {
            return -1;
        }

        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (a[mid] <= value && a[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }


}
