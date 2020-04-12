package com.proj.jonny.leetcode.stack;

import java.util.Stack;

/**
 * 基本计算器
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * Author: jonny
 * Time: 2020-04-05 00:15.
 */
public class Solution_224 {


    public static void main(String[] args) {
        calculate(" 3 +  1   + 5");
    }

    public static int calculate(String s) {

        String noWhitespaceString = s.trim().replaceAll("\\s", "");
        StringBuilder stringBuilder = new StringBuilder(noWhitespaceString);
        noWhitespaceString = stringBuilder.reverse().toString();
        System.out.println(noWhitespaceString);

        Stack<Character> stack = new Stack<>();
        for (char ch : noWhitespaceString.toCharArray()) {
            stack.push(ch);
        }
        return 0;
    }

}
