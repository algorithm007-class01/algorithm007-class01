package com.studyWeek1;

/**
 * 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // 新链表头节点指针
        ListNode prev = null;
        // 当前链表头节点指针
        ListNode curr = head;
        while (curr != null) {
            // 临时存当前节点下一个节点
            ListNode temp = curr.next;
            // 链接到新链表
            curr.next = prev;
            // 新链表指针后移
            prev = curr;
            // 当前指针后移
            curr = temp;
        }

        return prev;
    }
}
