package com.proj.jonny.leetcode.link;

import java.util.ArrayList;

/**
 * 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Solution_109 {

    public static void main(String[] args) {
        ListNode node = LinkUtils.of(-10, -3, 0, 5, 9);
        TreeNode root = sortedListToBST2(node);
        System.out.println(root);
    }

    /**
     * 有序链表转二分搜索树，返回转换后的二分搜索树的根节点
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        //此时fast到达链表尾结点，slow处在链表中间节点
        TreeNode root = new TreeNode(slow.val);
        //需要将链表断开，否则死循环
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    /**
     * 有序链表转二分搜索树，返回转换后的二分搜索树的根节点
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST2(ListNode head) {

        ArrayList<Integer> list = toArray(head);

        return convert(0, list.size() - 1, list);
    }

    /**
     * 将数组list中指定边界[left,right]内的元素转换为二分搜索树，并返回二分搜索树的根
     *
     * @param left
     * @param right
     * @param list
     * @return
     */
    private static TreeNode convert(int left, int right, ArrayList<Integer> list) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        ;

        if (left == right) {
            return node;
        }

        node.left = convert(left, mid - 1, list);
        node.right = convert(mid + 1, right, list);
        return node;
    }

    private static ArrayList<Integer> toArray(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
