package com.proj.jonny.leetcode.link;

/**
 * . 二进制链表转整数
 * <p>
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 */
public class Solution_1290 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(1);
        head.next = two;
        two.next = three;
        three.next = four;

        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder res = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            res.append(cur.val);
            cur = cur.next;
        }
        return Integer.parseInt(res.toString(), 2);
    }


}
