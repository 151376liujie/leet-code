package com.proj.jonny.leetcode.stack;

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
        System.out.println(isValid("("));
    }

    public static boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }
        //如果字符串个数是个奇数，它肯定不是个有效的字符串
        if (s.length() % 2 != 0){
            return false;
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
