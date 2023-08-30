package org.czy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czy
 * @date 2023/08/30
 * @Deprecated 13-罗马数字转整数
 **/
public class LeetCode13 {

    /*
    罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    通常情况下，罗马数字中小的数字在大的数字的右边。
    但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。

    同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    给定一个罗马数字，将其转换成整数。
    示例 1:
    输入: s = "III"
    输出: 3

    示例 2:
    输入: s = "IV"
    输出: 4

    示例 3:
    输入: s = "IX"
    输出: 9

    示例 4:
    输入: s = "LVIII"
    输出: 58
    解释: L = 50, V= 5, III = 3.

    示例 5:
    输入: s = "MCMXCIV"
    输出: 1994
    解释: M = 1000, CM = 900, XC = 90, IV = 4.
    */

    /**
     * 首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，
     * 如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        int x = 0;
        char[] array = s.toCharArray();
        if (array.length == 1) {
            return map.get(s.charAt(0));
        }
        if (1 > array.length || array.length > 15) {
            throw new RuntimeException("参数不合法");
        }
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                continue;
            }
            char now = array[i];
            char next = array[i + 1];
            if (map.get(now) < map.get(next)) {
                sum += map.get(next) - map.get(now) - x;
            } else {
                sum += map.get(now) + map.get(next) - x;
            }
            x = map.get(next);
        }
        return sum;
    }

    /**
     * 固定写死，把每种情况都考虑到位
     * */
    public static int romanToInt2(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getValue(s.charAt(i));
        }
        return res;
    }

    private static int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("D"));
        System.out.println(romanToInt2("XLIX"));
    }
}
