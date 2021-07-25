package com.atguigu.algorithm.linked_list;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: liqi
 * @create 2021-07-25 4:57 PM
 */

public class RemoveNode {

    /**
     * LeeCode 19 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNode1(ListNode head, int n){
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int i = 0;
        while (head != null){
            map.put(++i,head);
            head = head.next;
        }
        int size = map.size();
        // 要删除的第 index 个元素
        int index = size - n + 1;
        if (index == 1){
            node = node.next;
        }else {
            // 拿到要删除的前一个元素
            ListNode prev = map.get(index-1);
            prev.next = prev.next.next;
        }
        return node;
    }

    // 使用栈实现删除倒数第 n 个节点
    public ListNode removeNode2(ListNode head, int n){
        Stack<ListNode> stack = new Stack<>();
        // 定义一个哨兵节点
        ListNode sentinel = new ListNode(head,-1);
        ListNode prev = sentinel;
        while (prev != null){
            stack.push(prev);
            prev = prev.next;
        }
        ListNode node = null;
        // 通过倒数第 n+1 个节点删除倒数第 n 个节点
        for (int i = 0; i <= n; i++) {
            node = stack.pop();
        }
        node.next = node.next.next;
        return sentinel.next;
    }

    // 使用双指针实现删除倒数第 n 个节点
    public ListNode removeNode(ListNode head, int n){
        ListNode sentinel = new ListNode(head, -1);
        ListNode cur = sentinel;
        ListNode first = sentinel;
        ListNode second = null;
        for (int i = 0; i < n; i++) {
            second = cur.next;
            cur = cur.next;
        }
        // first 和 second 隔 n-1 个节点
        while (second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return sentinel.next;
    }
}
