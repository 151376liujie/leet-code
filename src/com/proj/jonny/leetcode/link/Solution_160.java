package com.proj.jonny.leetcode.link;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表:
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 *
 * @author liujie
 */
public class Solution_160 {

    public static void main(String[] args) {
        ListNode listNode1 = LinkUtils.of(5, 6, 1);
        ListNode listNode2 = LinkUtils.of(4, 1);
        ListNode node = new ListNode(8);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);

        listNode1.next.next.next = node;
        listNode2.next.next = node;

        System.out.println(getIntersectionNode(listNode1, listNode2));
    }

    /**
     * 先遍历一个链表,用一个set集合保存已经走过的节点,然后再遍历另一个链表的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode currA = headA;
        while (currA != null) {
            set.add(currA);
            currA = currA.next;
        }

        ListNode currB = headB;
        while (currB != null) {
            if (set.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }

        return null;
    }

}