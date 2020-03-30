package com.proj.jonny.leetcode.link;

public class LinkUtils {

    private LinkUtils() {
    }

    public static void main(String[] args) {
        ListNode head = of(1, 2, 3, 4, 5, 6);
        System.out.println(head);
    }

    public static ListNode of(int... arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }


}
