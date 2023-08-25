package org.czy.easy;

import java.util.Arrays;

/**
 * @author czy
 * @date 2023/08/25
 * @Deprecated 9-回文数
 **/
public class Leetcode9 {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     */

    /**
     * 解题思路:数字解析成数组,然后遍历对比前后对应的元素
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int[] tmp = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            tmp[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != tmp[tmp.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int test = 0;
        int temp = x;
        while (x != 0) {
            test = test * 10 + x % 10;
            x /= 10;
        }
        return temp == test;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome2(120021));
    }
}
