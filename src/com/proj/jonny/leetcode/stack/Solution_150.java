package com.proj.jonny.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 逆波兰表达式求职
 * <p>
 * <p>
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * Author: jonny
 * Time: 2020-04-06 17:29.
 */
public class Solution_150 {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {

        ArrayDeque<String> stack = new ArrayDeque<>();
        HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (String token : tokens) {
            if (operators.contains(token)) {
                String num1 = stack.pop();
                String num2 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = Integer.parseInt(num1) + Integer.parseInt(num2);
                        break;
                    case "-":
                        result = Integer.parseInt(num2) - Integer.parseInt(num1);
                        break;
                    case "*":
                        result = Integer.parseInt(num1) * Integer.parseInt(num2);
                        break;
                    case "/":
                        result = Integer.parseInt(num2) / Integer.parseInt(num1);
                        break;
                    default:
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

}
