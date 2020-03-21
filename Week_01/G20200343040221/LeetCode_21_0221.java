/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (60.29%)
 * Likes:    895
 * Dislikes: 0
 * Total Accepted:    202.8K
 * Total Submissions: 336.4K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // 方法1
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 方法2
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        if (l1.val <= l2.val) {
            ListNode node = new ListNode(l1.val);
            build(node, l1.next, l2);
            return node;
        }
        ListNode node = new ListNode(l2.val);
        build(node, l1, l2.next);
        return node;
    }

    public void build(ListNode node, ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return;
        }

        if (null == l1 || null == l2) {
            node.next = null == l1 ? l2 : l1;
            return;
        }

        if (l1.val <= l2.val) {
            ListNode newNode = new ListNode(l1.val);
            node.next = newNode;
            build(newNode, l1.next, l2);
        } else {
            ListNode newNode = new ListNode(l2.val);
            node.next = newNode;
            build(newNode, l1, l2.next);
        }
    }
}
// @lc code=end

