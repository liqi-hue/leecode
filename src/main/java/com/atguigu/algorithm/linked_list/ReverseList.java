package com.atguigu.algorithm.linked_list;

import java.util.Stack;

/**
 * @author: liqi
 * @create 2021-07-24 9:26 PM
 */

public class ReverseList {

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



    // 递归解决链表反转
    public ListNode reverseList2(ListNode head){
        if (head.getNext() == null){
            return head;
        }
        ListNode next = head.getNext();
        // prev 一直都是最后一个元素
        ListNode prev = reverseList2(head.getNext());
        next.setNext(head);
        head.setNext(null);
        return prev;
    }

    public ListNode reverseList(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        return null;
    }
}
