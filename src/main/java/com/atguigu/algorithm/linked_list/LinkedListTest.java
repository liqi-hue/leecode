package com.atguigu.algorithm.linked_list;

/**
 * @author: liqi
 * @create 2021-07-24 9:01 PM
 */

public class LinkedListTest {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node1.forEach();
        System.out.println();
        ReverseList list = new ReverseList();
        list.reverseList(node1).forEach();
//        reverseList1(node1).forEach();
    }
    // 循环解决链表反转
    public static ListNode reverseList1(ListNode head){
        ListNode result = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.getNext();
            cur.setNext(result);
            result = cur;
            cur = next;
        }
        return result;
    }
}
