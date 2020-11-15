package com.wang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> cacheNodes = new HashSet<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (!cacheNodes.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
