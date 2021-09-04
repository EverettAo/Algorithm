package leetcode.链表.反转链表;

import common.ListNode;

public class Solution {
    public ListNode reverseList_norec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, p = head, post;
        while (p != null) {
            post = p.next;
            p.next = pre;
            pre = p;
            p = post;
        }
        return pre;
    }

    public ListNode reverseList_rec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList_rec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
