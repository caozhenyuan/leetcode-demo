package org.czy.easy;

import java.util.Stack;

/**
 * @author czy
 * @date 2023/09/01
 * @Deprecated 20-有效括号
 **/
public class LeetCode20 {

    /*
     *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *有效字符串需满足：
     *左括号必须用相同类型的右括号闭合。
     *左括号必须以正确的顺序闭合。
     *每个右括号都有一个对应的相同类型的左括号。
     *
     *示例 1：
     *输入：s = "()"
     *输出：true

     *示例 2：
     *输入：s = "()[]{}"
     *输出：true

     *示例 3：
     *输入：s = "(]"
     *输出：false
     * */

    /**
     * 解题思路：使用栈进行消消乐
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[()]}"));
    }
}
