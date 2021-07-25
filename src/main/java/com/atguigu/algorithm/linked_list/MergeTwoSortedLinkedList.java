package com.atguigu.algorithm.linked_list;

/**
 * @author: liqi
 * @create 2021-07-25 3:52 PM
 */

public class MergeTwoSortedLinkedList {
    /**
     * LeeCode 21 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */

    public ListNode merge1(ListNode l1,ListNode l2){
        ListNode sentinel = new ListNode(-1);
        ListNode prev = sentinel;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.setNext(l1);
                prev = l1;
                l1 = l1.getNext();
            }else {
                prev.setNext(l2);
                prev = l2;
                l2 = l2.getNext();
            }
        }
        prev.setNext((l1 == null ? l2 : l1));
        return sentinel.getNext();
    }

    // 递归，返回合并后的结果
    public ListNode merge(ListNode l1,ListNode l2){

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
