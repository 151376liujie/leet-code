package com.proj.jonny.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例1：
 * 输入: "()"
 * 输出: true
 *
 * 示例2：
 * 输入: "()[]{}"
 * 输出: true
 *
 *示例3：
 *输入: "(]"
 * 输出: false
 *
 * 示例4：
 * 输入: "([)]"
 * 输出: false
 *
 * 示例5：
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution_20 {


    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                Character character = stack.pop();
                if (c == ')' && character != '('){
                    return false;
                }
                if (c == ']' && character != '['){
                    return false;
                }
                if (c == '}' && character != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
