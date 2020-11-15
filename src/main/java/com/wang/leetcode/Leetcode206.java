package com.wang.leetcode;

public class Leetcode206 {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = newHead;
            newHead = cur;
        }
        return newHead;
    }

    public static void main(String[] args) {
        //1->2->3->4->5

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Leetcode206 leetcode206 = new Leetcode206();
        ListNode head = leetcode206.reverseList(n1);

        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }

    }
}