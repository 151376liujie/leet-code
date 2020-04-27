package com.proj.jonny.leetcode.string.interview;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 面试题 16.26. 计算器
 * <p>
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * Author: jonny
 * Time: 2020-04-27 22:12.
 */
public class Solution_26 {

    public static void main(String[] args) {
//        System.out.println(calculate("13+2*20"));
//        System.out.println(calculate(" 43/2 "));
//        System.out.println(calculate(" 30+52 / 2 "));
//        System.out.println(calculate(" 1-1 + 1 "));
        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    public static int calculate(String expression) {
        expression = expression.trim();
        // 存储操作符对应的优先级，value值越高优先级越高
        HashMap<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('+', 0);
        priorityMap.put('-', 0);
        priorityMap.put('*', 1);
        priorityMap.put('/', 1);

        LinkedList<Character> operatorStack = new LinkedList<>();
        LinkedList<Integer> numberStack = new LinkedList<>();
        StringBuilder number = new StringBuilder();
        for (char ch : expression.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                continue;
            }
            //该字符是数字
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                numberStack.push(Integer.valueOf(number.toString()));
                number.delete(0, number.length());
                //该字符是操作符
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                } else {
                    Character topOperator = operatorStack.peek();
                    //当前操作符的优先级大于栈顶的操作符（比如当前操作符: *,栈顶操作符：+）
                    if (priorityMap.get(ch) > priorityMap.get(topOperator)) {
                        operatorStack.push(ch);
                    } else {
                        // 当前操作符优先级比栈顶操作符有小鸡小（比如当前操作符: +,栈顶操作符：*）
                        int result = calculate(numberStack, operatorStack);
                        numberStack.push(result);
                        operatorStack.push(ch);
                    }
                }
            }
        }
        // 把最后一个数字装进去
        if (number.length() > 0) {
            numberStack.push(Integer.valueOf(number.toString()));
            number = null;
        }
        while (!operatorStack.isEmpty() && !numberStack.isEmpty()) {
            int result = calculate(numberStack, operatorStack);
            numberStack.push(result);
        }

        return numberStack.pop();
    }

    private static int calculate(LinkedList<Integer> numberStack, LinkedList<Character> operatorStack) {

        if (!operatorStack.isEmpty()) {
            Character operator = operatorStack.pop();
            int num1 = numberStack.pop();
            int num2 = numberStack.pop();
            switch (operator) {
                case '+':
                    return num2 + num1;
                case '-':
                    return num2 - num1;
                case '*':
                    return num2 * num1;
                case '/':
                    return num2 / num1;
                default:
                    return 0;
            }
        }
        return 0;
    }
}
