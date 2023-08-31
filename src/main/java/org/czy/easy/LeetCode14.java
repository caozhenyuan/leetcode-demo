package org.czy.easy;

/**
 * @author czy
 * @date 2023/08/31
 * @Deprecated 14-最长公共前缀
 **/
public class LeetCode14 {

    /*
     *编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     *示例 1：
     *输入：strs = ["flower","flow","flight"]
     *输出："fl"
     *
     *示例 2：
     *输入：strs = ["dog","racecar","car"]
     *输出：""
     *解释：输入不存在公共前缀。
     *1 <= strs.length <= 200
     *0 <= strs[i].length <= 200
     *strs[i] 仅由小写英文字母组成
     *
     * */


    /**
     * 解题思路：公共前缀比所有字符串都短或者等于长度最短的,先随便获取一个元素，
     * 拿当前元素和数组里的每一个元素做对比，判断每个元素是否前匹配获取的那一个元素，
     * 如果不匹配，则让获取的那个元素从后往前缩减长度1，直到匹配为止,如果都不匹配则返回空字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1 || strs.length > 200) {
            return "";
        }
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (0 == s.length()) {
                    return "";
                }
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] array = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(array));
    }
}
