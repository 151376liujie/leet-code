package com.proj.jonny.leetcode.link;

/**
 * 反转一个单链表。
 * <p>
 * 示例：
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author liujie
 */
public class Solution_206 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node.next = node2;
        node2.next = node3;

        System.out.println(reverseListByDoublePoint(node));
    }

    /**
     * 双指针法进行反转
     *
     * @param head 头结点
     * @return 反转后的头结点
     */
    public static ListNode reverseListByDoublePoint(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 遍历链表,时间复杂度为O(n)
     *
     * @param head 头结点
     * @return 反转链表之后的头结点
     */
    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 递归实现链表翻转
     *
     * @param head 头指针
     * @return 反转之后的头结点
     */
    public static ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}