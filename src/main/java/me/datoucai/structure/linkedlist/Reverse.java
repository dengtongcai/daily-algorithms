package me.datoucai.structure.linkedlist;

import me.datoucai.base.ListNode;

public class Reverse {

    public static ListNode reverseListNode(ListNode head){
        ListNode result = null;
        ListNode next = null;
        while(next!=null){
            next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }
}
