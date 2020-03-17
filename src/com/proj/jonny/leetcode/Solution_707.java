package com.proj.jonny.leetcode;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * <b>示例:</b>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * 提示：
 * 所有val值都在 {1, 1000} 之内。
 * 操作次数将在  {1, 1000} 之内。
 * 请不要使用内置的 LinkedList 库。
 **/
public class Solution_707 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(7); // 7 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.addAtHead(2); // 2 -> 7 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.addAtHead(1); // 1 -> 2 -> 7 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.addAtIndex(3, 0); // 1 -> 2 -> 7 -> 0 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.deleteAtIndex(2); // 1 -> 2 -> 0 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.addAtHead(6); // 6 -> 1 -> 2 -> 0 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.addAtTail(4); // 6 -> 1 -> 2 -> 0 -> 4 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        System.out.println(linkedList.get(4)); // 4
//        linkedList.addAtHead(4); //4 -> 6 -> 1 -> 2 -> 0 -> 4 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.addAtIndex(5, 0);//4 -> 6 -> 1 -> 2 -> 0 -> 0 -> 4 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());
//        linkedList.addAtHead(6);//6 -> 4 -> 6 -> 1 -> 2 -> 0 -> 0 -> 4 -> null
//        System.out.println(linkedList + "size ：" + linkedList.getSize());

        String[] methodNames = {"addAtHead", "addAtTail", "addAtTail", "get", "get", "addAtTail", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "get", "addAtHead", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "get", "deleteAtIndex", "addAtTail", "addAtTail", "addAtHead", "addAtTail", "get", "deleteAtIndex", "addAtTail", "addAtHead", "addAtTail", "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "deleteAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtHead", "addAtHead", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtTail", "get", "addAtHead", "get", "addAtTail", "get", "addAtTail", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "get", "addAtIndex", "get", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtTail", "addAtTail", "addAtHead", "get", "addAtTail", "addAtHead", "addAtTail", "get", "addAtIndex"};
        int[][] methodArgs = {{84}, {2}, {39}, {3}, {1}, {42}, {1, 80}, {14}, {1}, {53}, {98}, {19}, {12}, {2}, {16}, {33}, {4, 17}, {6, 8}, {37}, {43}, {11}, {80}, {31}, {13, 23}, {17}, {4}, {10, 0}, {21}, {73}, {22}, {24, 37}, {14}, {97}, {8}, {6}, {17}, {50}, {28}, {76}, {79}, {18}, {30}, {5}, {9}, {83}, {3}, {40}, {26}, {20, 90}, {30}, {40}, {56}, {15, 23}, {51}, {21}, {26}, {83}, {30}, {12}, {8}, {4}, {20}, {45}, {10}, {56}, {18}, {33}, {2}, {70}, {57}, {31, 24}, {16, 92}, {40}, {23}, {26}, {1}, {92}, {3, 78}, {42}, {18}, {39, 9}, {13}, {33, 17}, {51}, {18, 95}, {18, 33}, {80}, {21}, {7}, {17, 46}, {33}, {60}, {26}, {4}, {9}, {45}, {38}, {95}, {78}, {54}, {42, 86}};

        HashMap<String, Class<?>[]> methodArgCountMap = new HashMap<>();
        methodArgCountMap.put("addAtHead", new Class[]{int.class});
        methodArgCountMap.put("addAtTail", new Class[]{int.class});
        methodArgCountMap.put("get", new Class[]{int.class});
        methodArgCountMap.put("addAtIndex", new Class[]{int.class, int.class});
        methodArgCountMap.put("deleteAtIndex", new Class[]{int.class});

        for (int i = 0; i < methodNames.length; i++) {
            Class<?>[] classes = methodArgCountMap.get(methodNames[i]);
            Method method = MyLinkedList.class.getDeclaredMethod(methodNames[i], classes);
            int length = methodArgs[i].length;
            Object result = null;
            try {
                if (length == 1) {
                    result = method.invoke(linkedList, methodArgs[i][0]);
                    System.out.println("method name : " + methodNames[i] + " ,arg: " + methodArgs[i][0] + ", result is: " + result);
                } else if (length == 2) {
                    result = method.invoke(linkedList, methodArgs[i][0], methodArgs[i][1]);
                    System.out.println("method name : " + methodNames[i] + " ,arg: " + methodArgs[i][0] + ", " + methodArgs[i][1] + ", result is: " + result);
                }
            } catch (Exception e) {
                System.out.println("execut eoorl");
                break;
            }
            System.out.println(linkedList);
        }

    }
}
