/*
 * @lc app=leetcode.cn id=21 lang=csharp
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        // 迭代法
        // 引入一个头节点，用于最后结果的返回
        ListNode preHead = new ListNode(-1);
        // 添加一个指针，指代当前进度，=preHead用于初始化head的next
        ListNode prev = preHead;
        // 需都不为空才进入判断
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val)
            {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 最后剩下的直接接到末尾
        prev.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }
}
// @lc code=end

