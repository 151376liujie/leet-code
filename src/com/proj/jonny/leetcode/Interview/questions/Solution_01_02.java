package com.proj.jonny.leetcode.Interview.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class Solution_01_02 {


    public static void main(String[] args) {
        System.out.println(checkPermutation("abcc", "cab"));
    }

    public static boolean checkPermutation(String s1, String s2) {

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (map2.containsKey(c)) {
                Integer count = map2.get(c);
                map2.put(c, count + 1);
            } else {
                map2.put(c, 1);
            }
        }

        if (map.size() != map2.size()){
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey())){
                return false;
            }
            if (!entry.getValue().equals(map2.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }

}
