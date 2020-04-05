package com.proj.jonny.leetcode.stack.interview;

import java.util.ArrayDeque;
import java.util.StringJoiner;

/**
 * 栈的最小值
 * <p>
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * Author: jonny
 * Time: 2020-04-05 22:18.
 */
public class Solution_03_02 {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.pop();
        int top = stack.top();
        System.out.println(top);
        int min = stack.getMin();
        System.out.println(min);
    }

    static class MinStack {

        private ArrayDeque<Node> deque;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            deque = new ArrayDeque<>();
        }

        public void push(int x) {
            if (deque.isEmpty()) {
                deque.push(new Node(x, x));
            } else {
                Node peek = deque.peek();
                int min = peek.min;
                if (peek.min > x) {
                    min = x;
                }
                deque.push(new Node(x, min));
            }

        }

        public void pop() {
            deque.pop();
        }

        public int top() {
            Node peek = deque.peek();
            if (peek == null) {
                return Integer.MIN_VALUE;
            }
            return peek.value;
        }

        public int getMin() {
            Node peek = deque.peek();
            if (peek == null) {
                return Integer.MIN_VALUE;
            }
            return peek.min;
        }

        private class Node {
            int value;
            int min;

            public Node(int value) {
                this.value = value;
            }

            public Node(int value, int min) {
                this.value = value;
                this.min = min;
            }


            @Override
            public String toString() {
                return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                        .add("value=" + value)
                        .add("min=" + min)
                        .toString();
            }
        }

    }
}
