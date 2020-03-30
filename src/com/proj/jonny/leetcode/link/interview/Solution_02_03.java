package com.proj.jonny.leetcode.link.interview;

import com.proj.jonny.leetcode.link.ListNode;

/**
 * Time: 2020-03-16 12:35.
 *
 * @author liujie361
 */
public class Solution_02_03 {

    public static void deleteNode(ListNode node) {
        ListNode cur = node;
        while (cur.next != null){
            cur.val = cur.next.val;
            //走到了倒数第二个节点的位置了
            if (cur.next.next == null){
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        node_1.next = node_2;
        ListNode node_3 = new ListNode(3);
        node_2.next = node_3;
        ListNode node_4 = new ListNode(4);
        node_3.next = node_4;
        ListNode node_5 = new ListNode(5);
        node_4.next = node_5;
        ListNode node_6 = new ListNode(6);
        node_5.next = node_6;

        deleteNode(node_3);
        System.out.println(node_1);
    }
}
