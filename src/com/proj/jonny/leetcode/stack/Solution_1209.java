package com.proj.jonny.leetcode.stack;

import java.util.ArrayDeque;

/**
 * 删除字符串中的所有相邻重复项 II
 * <p>
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 * <p>
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * <p>
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * <p>
 * 本题答案保证唯一。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 * <p>
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 * <p>
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 * <p>
 */

public class Solution_1209 {


    public static void main(String[] args) {
//        System.out.println(removeDuplicates("abcd", 2));
//        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
//        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
//        System.out.println(removeDuplicates("dtpdtaaaaaaaaappppppppppppppppppppaaaaaaaaaaxxxxxxxxxxxxxxsssssssssjjjjjjjjjjjjjjjjjjjjxxxxxxxxxxxxxxxxxxxxsssssssjjjjjjjjjjjjjjjjjjjjssssxxxxxxatdwvvpctpggggggggggggggggggggajagglaaaaaaaaaaaaaaaaaaaa", 4));
    }

    public static String removeDuplicates(String s, int k) {

        //存放每个字符出现的次数，当出现的次数达到k时，从栈中pop出k个元素
        ArrayDeque<Integer> countStack = new ArrayDeque<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
                countStack.push(1);
            } else { // stack.peek() == ch
                stack.push(ch);
                countStack.push(countStack.pop() + 1);
            }

            if (countStack.peek() == k) {
                for (int i = 0; i < k; i++) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                countStack.pop();
            }
        }
        StringBuilder res = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

}
