package com.proj.jonny.leetcode.link.interview;

import com.proj.jonny.leetcode.link.LinkUtils;
import com.proj.jonny.leetcode.link.ListNode;

import java.util.HashSet;

/**
 * 面试题 02.01. 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class Solution_02_01 {

    public static void main(String[] args) {
        ListNode head = LinkUtils.of(1, 2, 3, 3, 3, 2, 1);
        System.out.println(removeDuplicateNodes(head));

        System.out.println(removeDuplicateNodes(LinkUtils.of(1, 1, 1, 1, 2)));
        System.out.println(removeDuplicateNodes(LinkUtils.of(1, 1, 1, 1, 1)));

        System.out.println(deleteNode(LinkUtils.of(1, 2, 3, 4, 5), 3));
    }

    public static ListNode removeDuplicateNodes(ListNode head) {

        HashSet<Integer> set = new HashSet<>();

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val)) {
                ListNode next = cur.next;
                prev.next = next;
                cur.next = null;
                cur = next;
            } else {
                set.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteNode(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;

        ListNode cur = head;
        ListNode prev = dummyHead;

        while (cur != null) {
            if (cur.val == val) {
                ListNode next = cur.next;
                prev.next = next;
                cur.next = null;
                cur = next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
