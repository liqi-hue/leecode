package com.atguigu.algorithm.linked_list;

/**
 * @author: liqi
 * @create 2021-07-24 8:56 PM
 */

public class ListNode {

    public ListNode next;
    public int val;

    public ListNode(ListNode next, int value) {
        this.next = next;
        this.val = value;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode() {
    }

    public ListNode(int value) {
        this.val = value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void forEach(){
        System.out.print(this.val + " -> ");
        if (this.next != null){
            this.next.forEach();
        }else {
            System.out.print("null");
        }
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + val +
                '}';
    }

}
