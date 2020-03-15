package com.szp.leetcode.q1_50;
/*
21. 合并两个有序链表
*将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
* */
public class A21_Merge_two_sorted_lists {

//     Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
     /*
     * 只实现了一种，还有递归实现方法
     * class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}     * */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(null == l1)
                return l2;
            if(null == l2)
                return l1;
            ListNode l = new ListNode(0);
            ListNode result = l;
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    l.next = l1;
                    l1 = l1.next;
                }else{
                    l.next = l2;
                    l2 = l2.next;
                }
                l = l.next;
            }
            if(null == l1){
                l.next = l2;
            }else{
                l.next = l1;
            }
            return result.next;
        }
    }
}
