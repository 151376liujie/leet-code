package com.proj.jonny.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 叉树的堂兄弟节点
 * <p>
 * <p>
 * <p>在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * Author: jonny
 * Time: 2020-04-12 09:47.
 */
public class Solution_993 {


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildFrom(1, 2, 3, 4);
        System.out.println(isCousins(root, 4, 3));
        //[1,2,3,null,4,null,5], x = 5, y = 4
        root = TreeNodeUtils.buildFrom(1, 2, 3, null, 4, null, 5);
        System.out.println(isCousins(root, 5, 4));

        root = TreeNodeUtils.buildFrom(1, 2, 3, null, 4);
        System.out.println(isCousins(root, 2, 3));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        //保存每个节点的值和这个节点的层级
        HashMap<Integer, Integer> nodeValueAndLeverMap = new HashMap<>();
        // 保存每隔节点的值对应的父节点的值
        HashMap<Integer, Integer> nodeValueAndParentNodeValueMap = new HashMap<>();

        nodeValueAndLeverMap.put(root.val, 0);
        nodeValueAndParentNodeValueMap.put(root.val, -1);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 从map中获取到父节点的当前层级，子节点的层级 = 父节点的层级 + 1
            Integer parentLevel = nodeValueAndLeverMap.get(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nodeValueAndLeverMap.put(node.left.val, parentLevel + 1);
                nodeValueAndParentNodeValueMap.put(node.left.val, node.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                nodeValueAndLeverMap.put(node.right.val, parentLevel + 1);
                nodeValueAndParentNodeValueMap.put(node.right.val, node.val);
            }
        }
        nodeValueAndLeverMap.forEach((val, level) -> System.out.println("value is: " + val + ", and lever is: " + level));
        nodeValueAndParentNodeValueMap.forEach((val, parentValue) -> System.out.println("value is: " + val + ", and parent value is: " + parentValue));

        // x 和 y只要有一个不再map中，说明有一个节点不在树节点中
        if (!nodeValueAndLeverMap.containsKey(x) || !nodeValueAndLeverMap.containsKey(y) || !nodeValueAndParentNodeValueMap.containsKey(x) || !nodeValueAndParentNodeValueMap.containsKey(y)) {
            return false;
        }

        return nodeValueAndLeverMap.get(x).equals(nodeValueAndLeverMap.get(y)) && !nodeValueAndParentNodeValueMap.get(x).equals(nodeValueAndParentNodeValueMap.get(y));
    }

}
