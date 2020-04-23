package com.proj.jonny.leetcode.array;

import com.proj.jonny.leetcode.tree.TreeNode;
import com.proj.jonny.leetcode.tree.TreeNodeUtils;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * <p>
 * Author: jonny
 * Time: 2020-04-21 09:54.
 */
public class Solution_112 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = TreeNodeUtils.buildFrom(1, 2, 3, null, null, 4, 5);
//        TreeNode root = TreeNodeUtils.buildFrom(5, 2, 3, null, null, 2, 4, 3, 1);
//        TreeNode root = TreeNodeUtils.buildFrom();
        String serialize = codec.serialize(root);
        System.out.println(serialize);
//        System.out.println(codec.deserialize(serialize));
    }


    private static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = levelOrder(root);
            return Arrays.toString(list.toArray());
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            data = data.substring(1, data.length() - 1);
            if (data.isEmpty()) {
                return null;
            }
            for (String num : data.split(",")) {
                num = num.trim();
                list.add("null".equals(num) ? null : Integer.valueOf(num));
            }
            return buildFrom(list);
        }

        private TreeNode buildFrom(List<Integer> list) {

            TreeNode root = new TreeNode(list.get(0));
            ArrayDeque<TreeNode> queue = new ArrayDeque<>(list.size());
            queue.offer(root);
            int cur = 1;
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();

            }

            return null;
        }

        private List<String> levelOrder(TreeNode node) {

            List<String> list = new ArrayList<>();

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(node);

            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    list.add(null);
                } else {
                    list.add(String.valueOf(tmp.val));
                }
                if (tmp != null) {
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
//             list 尾部中多加了一些null元素，需要从尾部删除这些多余的null元素
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                if (list.get(i) == null) {
                    list.remove(i);
                } else {
                    break;
                }
            }
            return list;
        }
    }
}
