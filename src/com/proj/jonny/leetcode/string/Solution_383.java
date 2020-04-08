package com.proj.jonny.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 * <p>
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * Author: jonny
 * Time: 2020-04-08 22:55.
 */
public class Solution_383 {


    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            Integer count = map.get(ch);
            if (count - 1 == 0) {
                map.remove(ch);
            } else {
                map.replace(ch, count - 1);
            }
        }
        return true;
    }

}
