package com.wang.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHead = null;
        ListNode sumTail = null;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        int carry = 0; //进位;
        for(;curL1 != null || curL2 != null;){
            int v1 = 0;
            int v2 = 0;
            if (curL1 != null){
                v1 = curL1.val;
            }
            if (curL2 != null){
                v2 = curL2.val;
            }
            int sum = carry + v1 + v2;
            carry = sum / 10;
            if (sumHead == null){
                sumTail = sumHead = new ListNode(sum % 10);
            }else {
                sumTail.next = new ListNode(sum % 10);
                sumTail = sumTail.next;
            }
            if (curL1 != null)
            curL1 = curL1.next;
            if (curL2 != null)
            curL2 = curL2.next;
        }
        if (carry > 0){
            sumTail.next = new ListNode(carry);
        }
        return sumHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        Leetcode2 leetcode2 = new Leetcode2();
        ListNode listNode = leetcode2.addTwoNumbers(listNode1, listNode4);

        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

}


