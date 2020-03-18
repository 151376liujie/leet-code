package com.proj.jonny.leetcode.link;

import java.util.StringJoiner;

/**
 * @author jonny
 * Time: 2020-03-17 13:20.
 */
public class MyLinkedList {

    private Node dummyHead;
    private Node tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        dummyHead = new Node(-1);
        tail = dummyHead;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node inserted = new Node(val);
        inserted.next = cur.next;
        cur.next = inserted;
        size++;
        tail = inserted;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        //空链表无法删除
        if (size == 0) {
            return;
        }

        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Node delNode = cur.next;
        cur.next = delNode.next;
        delNode.next = null;
        size--;

        //说明已经遍历到数组尾节点了
        if (cur.next == null) {
            tail = cur;
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null) {
            builder.append(curr.data).append("->");
            curr = curr.next;
        }
        builder.append("null");

        return builder.toString();
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }


        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("data=" + data)
                    .add("next=" + next)
                    .toString();
        }
    }
}
